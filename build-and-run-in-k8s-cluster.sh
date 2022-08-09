#!/bin/bash
echo "--- Use minikube as docker host ---"
eval $(minikube -p minikube docker-env)
echo "--- Build service ---"
cd service
./mvnw spring-boot:build-image
kubectl apply -f k8s
cd ..
echo "--- Build client ---"
cd client
./mvnw spring-boot:build-image
kubectl apply -f k8s
echo "--- Sleep 10 s ---"
sleep 10
kubectl get all
echo "######################################"
echo "### Open http://[external-ip]:8081 ###"
echo "### Cleanup with ./cleanup.sh      ###"
echo "######################################"