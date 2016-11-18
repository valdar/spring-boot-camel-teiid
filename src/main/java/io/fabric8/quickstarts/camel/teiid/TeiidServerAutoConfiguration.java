/**
 *  Copyright 2005-2016 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package io.fabric8.quickstarts.camel.teiid;

import java.util.Objects;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.teiid.jdbc.TeiidDataSource;

/**
 * A bean that manages the creation of the global Teiid {@code EmbeddedServer}.
 */
@Configuration
@EnableConfigurationProperties(TeiidServerProperties.class)
public class TeiidServerAutoConfiguration {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public DataSource teiidDS(TeiidServerProperties prop, Environment environment) throws Exception {
        String host = getServiceInfo(environment, prop.getServiceName(), "host", null);
        String port = getServiceInfo(environment, prop.getServiceName(), "port", prop.getPortName());

        logger.info("Connecting to the Teiid server at {} on port {}", host, port);

        TeiidDataSource ds = new TeiidDataSource();
        ds.setDatabaseName(prop.getDatabaseName());
        ds.setUser(prop.getUsername());
        ds.setPassword(prop.getPassword());
        ds.setServerName(host);
        ds.setPortNumber(Integer.parseInt(port));

        return ds;
    }

    private String getServiceInfo(Environment environment, String serviceName, String infoType, String subType) {
        String propertyName = serviceName.toUpperCase().replace("-", "_");
        propertyName += "_SERVICE_" + infoType.toUpperCase();
        if (subType != null && subType.trim().length() > 0) {
            propertyName += "_" + subType.toUpperCase().replace("-", "_");
        }

        String info = environment.getProperty(propertyName);
        Objects.requireNonNull(info, "Service " + infoType + " not found in the environment (" + propertyName + ")");
        return info;
    }

}
