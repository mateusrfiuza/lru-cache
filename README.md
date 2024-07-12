# LRU Cache Project

## Overview

This project implements an LRU (Least Recently Used) cache using Java 21. The LRU cache is designed to store cache items with a specific limit, evicting the least recently used items when the cache exceeds its capacity. The implementation leverages `LinkedHashMap` to maintain the order of access and ensure efficient retrieval and eviction operations.

## Features

- **LRU Eviction Policy**: Automatically removes the least recently used items when the cache size exceeds the specified limit.
- **Extensible Cache Items**: Supports different types of cache items by extending the `BaseCacheItem` class.
- **Custom Cache Limits**: Configurable cache size through the `CacheLimits` class.

## Prerequisites

- Java 21
- Gradle

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/mateusrfiuza/lru-cache
cd lru-cache

Build the Project
Use Gradle to build the project:

bash
Copy code
./gradlew build
Running Tests
To run the tests, use the following command:

bash
Copy code
./gradlew test