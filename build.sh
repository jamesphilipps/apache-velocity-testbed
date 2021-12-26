#!/bin/bash

gradle clean build

docker build . --tag ghcr.io/jamesphilipps/apache-velocity-testbed:latest