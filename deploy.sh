#!/bin/bash
# Shell script to deploy todo-app to Kubernetes

echo "🚀 Deploying todo-app to Kubernetes..."

# Check if kubectl is available
if ! command -v kubectl &> /dev/null; then
    echo "❌ kubectl not found. Please install kubectl first."
    exit 1
fi

echo "✅ kubectl found"

# Build the Spring Boot application Docker image
echo "🏗️  Building Spring Boot application image..."
docker build -t spring-app:latest .

if [ $? -ne 0 ]; then
    echo "❌ Docker build failed"
    exit 1
fi

echo "✅ Spring Boot image built successfully"

# Apply Kubernetes manifests
echo "📦 Applying Kubernetes manifests..."
kubectl apply -f k8s-manifest.yaml

if [ $? -ne 0 ]; then
    echo "❌ Kubernetes deployment failed"
    exit 1
fi

echo "✅ Kubernetes manifests applied successfully"

# Wait for deployments to be ready
echo "⏳ Waiting for deployments to be ready..."
kubectl wait --for=condition=available --timeout=300s deployment --all -n todo-app

if [ $? -ne 0 ]; then
    echo "❌ Deployments did not become ready in time"
else
    echo "✅ All deployments are ready"
fi

# Display service information
echo ""
echo "📋 Service Information:"
kubectl get services -n todo-app

echo ""
echo "🔧 To access the services locally, use port-forwarding:"
echo "Spring App:  kubectl port-forward -n todo-app svc/spring-app 8080:8080"
echo "Grafana:     kubectl port-forward -n todo-app svc/grafana 3000:3000"
echo "Prometheus:  kubectl port-forward -n todo-app svc/prometheus 9090:9090"

echo ""
echo "🎉 Deployment completed!"