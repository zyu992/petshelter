#!/bin/bash
./gradlew build && mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)
docker build --build-arg DEPENDENCY=build/dependency -t jumjieyang/petshelter-backend .
docker tag jumjieyang/petshelter-backend:latest jumjieyang/petshelter-backend
docker push jumjieyang/petshelter-backend
