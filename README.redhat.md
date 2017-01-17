# Spring-Boot Camel-Teiid QuickStart

This example demonstrates how to connect Apache Camel to a remote JBoss Data Virtualization (or Teiid) Server using the JDBC protocol.

In the example, a Camel route periodically generates random categories then executes aggregate queries in the remote Teiid virtual database (VDB),
performing different paths depending on the result of each query.

This quickstart assumes that the Teiid server is already running on Openshift with the example `Portfolio` virtual database deployed.
One simple way to run a Teiid server and deploy the `Portfolio` virtual database is following the documentation of the JDV xPaaS image for Openshift related to the `datavirt63-basic-s2i` template.

During the JDV server creation, the username and password fields for the Teiid user should be filled in.
The same credentials must be used in this quickstart for the properties `teiid.username` and `teiid.password` of the `application.properties` file. When using the Openshift S2I build mode, the credentials must be provided in the template.

### Building

The example can be built with

    mvn clean install


### Running the example locally

The example can be run locally using the following Maven goal:

    mvn spring-boot:run


### Running the example in OpenShift

It is assumed a running OpenShift platform is already running. 

Assuming your current shell is connected to OpenShift so that you can type a command like

```
oc get pods
```

Then the following command will package your app and run it on OpenShift:

```
mvn fabric8:deploy
```

To list all the running pods:

    oc get pods

Then find the name of the pod that runs this quickstart, and output the logs from the running pods with:

    oc logs <name of pod>

### Running via an S2I Application Template

Applicaiton templates allow you deploy applications to OpenShift by filling out a form in the OpenShift console that allows you to adjust deployment parameters.  This template uses an S2I source build so that it handle building and deploying the application for you.

First, import the Fuse image streams:

    oc create -f https://raw.githubusercontent.com/jboss-fuse/application-templates/fis-2.0.x.redhat/fis-image-streams.json

Then create the quickstart template:

    oc create -f https://raw.githubusercontent.com/jboss-fuse/application-templates/fis-2.0.x.redhat/quickstarts/spring-boot-camel-teiid-template.json

Now when you use "Add to Project" button in the OpenShift console, you should see a template for this quickstart. 
