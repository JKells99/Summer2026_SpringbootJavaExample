#if you see this just ignore it for now, I am testing something new for fun to make life easier/ and to just understand

.PHONY: build run package clean logs

# Build the Docker image
build:
	docker buildx build \
    		--platform linux/amd64,linux/arm64 \
    		-t jkells/reviewapp:latest \
    		.


# Run the container
run:
	docker compose up
# Build JAR using Maven
package:
	mvn clean package -DskipTests

# Show container logs
logs:
	docker compose logs -f myapp-main

# Remove old Docker images and containers
clean:
	docker system prune -af