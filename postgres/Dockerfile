FROM postgres
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD pgadmin
ENV POSTGRES_DB dataSourceExemplo
COPY create.sql /docker-entrypoint-initdb.d/
