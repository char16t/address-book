#!/bin/sh

cd /vagrant/address-book
mvn package
sudo cp ear/target/addressbook-ear-1.0.ear /opt/wildfly/standalone/deployments
sudo touch /opt/wildfly/standalone/deployments/addressbook-ear-1.0.ear.dodeploy
