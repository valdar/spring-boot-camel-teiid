# Spring-Boot Camel-Teiid QuickStart

This example demonstrates how to connect Apache Camel to a remote JBoss Data Virtualization (or Teiid) Server using the JDBC protocol.

In the example, a Camel route periodically generates random categories then executes aggregate queries in the remote Teiid virtual database (VDB),
performing different paths depending on the result of each query.

This quickstart assumes that the Teiid server is already running on Openshift (or Kubernetes) with the example `Portfolio` virtual database deployed.
One simple way to run a Teiid server and deploy the `Portfolio` virtual database is following the documentation of the JDV xPaaS image for Openshift related to 
the `datavirt63-basic-s2i` template.

During the JDV server creation, the username and password fields for the Teiid user should be filled in.
The same credentials must be used in this quickstart for the properties `teiid.username` and `teiid.password` of the `application.properties` file.
When using the Openshift S2I build mode, the credentials must be provided in the template.

### Building

The example can be built with

    mvn clean install


### Running the example locally

The example can be run locally using the following Maven goal:

    mvn spring-boot:run


### Running the example in Kubernetes

It is assumed a running Kubernetes platform is already running. If not you can find details how to [get started](http://fabric8.io/guide/getStarted/index.html).

Assuming your current shell is connected to Kubernetes or OpenShift so that you can type a command like

```
kubectl get pods
```

or for OpenShift

```
oc get pods
```

Then the following command will package your app and run it on Kubernetes:

```
mvn fabric8:run
```

To list all the running pods:

    oc get pods

Then find the name of the pod that runs this quickstart, and output the logs from the running pods with:

    oc logs <name of pod>

You can also use the [fabric8 developer console](http://fabric8.io/guide/console.html) to manage the running pods, and view logs and much more.


### More details

You can find more details about running this [quickstart](http://fabric8.io/guide/quickstarts/running.html) on the website. This also includes instructions how to change the Docker image user and registry.
