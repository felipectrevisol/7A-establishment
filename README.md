# Todo App - Kubernetes Deployment Guide

Este repositório contém uma aplicação Todo App com monitoramento usando Spring Boot, Prometheus e Grafana, configurada para implantação em um cluster Kubernetes.

## Pré-requisitos

- Docker instalado e configurado
- Cluster Kubernetes configurado
- kubectl instalado e configurado

## Estrutura do Projeto

O projeto inclui:

- Aplicação Spring Boot
- Prometheus para coleta de métricas
- Grafana para visualização de métricas
- Configurações Kubernetes para todos os componentes

### Implantação

Execute o script deploy.sh:

  ```
   ./deploy.sh
  ```

### Implantação Manual

Siga estes passos para implantar manualmente:

1. **Verifique se o kubectl está disponível**
   ```powershell
   kubectl version --client
   ```

2. **Construa a imagem Docker da aplicação Spring Boot**
   ```powershell
   docker build -t spring-app:latest .
   ```

3. **Aplique os manifestos Kubernetes**
   ```powershell
   kubectl apply -f k8s-manifest.yaml
   ```

4. **Aguarde até que as implantações estejam prontas**
   ```powershell
   kubectl wait --for=condition=available --timeout=300s deployment --all -n todo-app
   ```

5. **Verifique as informações do serviço**
   ```powershell
   kubectl get services -n todo-app
   ```

## Acessando os Serviços

Para acessar os serviços localmente, use o port-forwarding:

- **Spring App**:
  ```powershell
  kubectl port-forward -n todo-app svc/spring-app 8080:8080
  ```

- **Grafana**:
  ```powershell
  kubectl port-forward -n todo-app svc/grafana 3000:3000
  ```

- **Prometheus**:
  ```powershell
  kubectl port-forward -n todo-app svc/prometheus 9090:9090
  ```

## Monitoramento

- Acesse o Grafana em `http://localhost:3000` (usuário/senha padrão: admin/admin)
- Acesse o Prometheus em `http://localhost:9090`
- A aplicação Spring Boot expõe métricas em `http://localhost:8080/actuator/prometheus`

## Solução de Problemas

Se encontrar problemas durante a implantação:

1. Verifique se todos os pré-requisitos estão instalados
2. Verifique os logs dos pods:
   ```powershell
   kubectl logs -n todo-app deployment/spring-app
   kubectl logs -n todo-app deployment/prometheus
   kubectl logs -n todo-app deployment/grafana
   ```
3. Verifique o status dos pods:
   ```powershell
   kubectl get pods -n todo-app
   ```

## Limpeza

Para remover todos os recursos criados:

```powershell
kubectl delete -f k8s-manifest.yaml
```