sudo docker stop jsf
sudo docker stop core
sudo docker stop postgres
sudo docker rm jsf
sudo docker rm core
sudo docker rm postgres
sudo docker rmi -f datasource/jsf
sudo docker rmi -f datasource/core
sudo docker rmi -f datasource/postgres
