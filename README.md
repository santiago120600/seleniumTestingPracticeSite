#	Selenium Test

## Build
`docker build -t santiago120600/selenium-docker .`

`docker-compose up`

## Run tests out of the container
**Run selenium with docker**

`docker run -d -p 4444:4444 --shm-size="2g" selenium/standalone-chrome:4.1.3-20220327`

**Run test**

`mvn test`