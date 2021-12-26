#!/bin/bash

gradle clean build

docker build . --tag apache-velocity-testbed:latest