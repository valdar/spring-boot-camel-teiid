# Spring-Boot and Camel-Teiid QuickStart

This example demonstrates how to connect Apache Camel to a remote JBoss Data Virtualization (or Teiid) Server using the JDBC protocol.

In the example, a Camel route periodically generates random categories then executes aggregate queries in the remote Teiid virtual database (VDB),
performing different paths depending on the result of each query.

This quickstart assumes that the Teiid server is already running on OpenShift with the example `Portfolio` virtual database deployed.
One simple way to run a Teiid server and deploy the `Portfolio` virtual database is following the documentation of the JDV xPaaS image for OpenShift related to the `datavirt63-basic-s2i` template.

During the JDV server creation, the username and password fields for the Teiid user should be filled in.
The same credentials must be used in this quickstart for the properties `teiid.username` and `teiid.password` of the `application.properties` file. When using the OpenShift S2I build mode, the credentials must be provided in the template.

### Building

The example can be built with

    mvn clean install

### Running the example in OpenShift

It is assumed that:
- OpenShift platform is already running, if not you can find details how to [Install OpenShift at your site](https://docs.openshift.com/container-platform/3.3/install_config/index.html).
- Your system is configured for Fabric8 Maven Workflow, if not you can find a [Get Started Guide](https://access.redhat.com/documentation/en/red-hat-jboss-middleware-for-openshift/3/single/red-hat-jboss-fuse-integration-services-20-for-openshift/)

The example can be built and run on OpenShift using a single goal:

    mvn fabric8:deploy

To list all the running pods:

    oc get pods

Then find the name of the pod that runs this quickstart, and output the logs from the running pods with:

    oc logs <name of pod>

You can also use the OpenShift [web console](https://docs.openshift.com/container-platform/3.3/getting_started/developers_console.html#developers-console-video) to manage the running pods, and view logs and much more.

### Running via an S2I Application Template

Application templates allow you deploy applications to OpenShift by filling out a form in the OpenShift console that allows you to adjust deployment parameters.  This template uses an S2I source build so that it handle building and deploying the application for you.

First, import the Fuse image streams:

    oc create -f https://raw.githubusercontent.com/jboss-fuse/application-templates/GA/fis-image-streams.json

Then create the quickstart template:

    oc create -f https://raw.githubusercontent.com/jboss-fuse/application-templates/GA/quickstarts/spring-boot-camel-teiid-template.json

Now when you use "Add to Project" button in the OpenShift console, you should see a template for this quickstart. 

