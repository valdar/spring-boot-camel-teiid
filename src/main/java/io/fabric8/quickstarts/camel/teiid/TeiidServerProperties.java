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

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for the remote Teiid server.
 */
@ConfigurationProperties(prefix = "teiid")
public class TeiidServerProperties {

    /**
     * The name of the Teiid virtual database.
     */
    private String databaseName;

    /**
     * The username for the authentication with the remote server.
     */
    private String username;

    /**
     * The username for the authentication with the remote server.
     */
    private String password;

    /**
     * The name of the Kubernetes service to connect to.
     */
    private String serviceName = "datavirt-app";

    /**
     * The name of kubernetes port (when the same service is used for multiple named ports).
     */
    private String portName = "jdbc";

    public TeiidServerProperties() {
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }
}
