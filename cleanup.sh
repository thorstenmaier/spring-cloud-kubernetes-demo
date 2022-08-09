#!/bin/bash
echo "--- Cleanup ---"
kubectl delete service client
kubectl delete deployment client
kubectl delete service service
kubectl delete deployment service
echo "--- Sleep 5 s ---"
sleep 5
kubectl get all