FROM amazoncorretto:15
ARG version
ENV VERSION=${version}
COPY target/OversightReview-${VERSION}-shaded.jar /opt/oversight/oversight.jar
WORKDIR /opt/oversight
EXPOSE 8080
COPY start.sh /opt/oversight
ENTRYPOINT ["/opt/oversight/start.sh"]
