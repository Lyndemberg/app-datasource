sudo docker build -t datasource/postgres ./postgres
sudo docker build -t datasource/core ./core-datasource
sudo docker build -t datasource/jsf ./jsf-datasource
sudo docker run -d --name postgres datasource/postgres
sudo docker run -d --name core --link postgres:host-postgres datasource/core
sudo docker run -d -p 8080:8080 --name jsf --link core:host-core datasource/jsf

