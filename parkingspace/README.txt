To Run the Application Please follow below instructions - 
1. Extract the zip parkingspace.zip in a folder.
2. go into the folder you extract parkingspace.zip.
3. run "mvn clean install"
4. run "cd target"
5. run "java -jar parkingspace-0.0.1-SNAPSHOT.jar"

your application will start on port 8080


In /src/main/resources there is parkingspace.properties where you can set how many parking space should be present in our Parking space.
 
 Sample URLs
 
 POST localhost:8080/parking/allot
 Purpose : To Provide parking to new vehicle in parking space
 Body of this URL is {"vehicleNumber":"ajshd","vehicleModel":"dka","vehicleType":"FourWheeler","vehicleColor":"black","vehicleBrand":"hyundai","parkingCostType":"daily"}
 Response of this {"parkingId":"c32f73d9-e600-460c-ac9a-947b681c597c","parkingSpaceId":"2","vehicle":{"hourlyParkingCost":100,"dailyParkingCost":300,"vehicleType":"FourWheeler"},"parkingTime":"2020-07-25T14:51:48.931+00:00","parkingCostType":"daily","vehicleInfo":{"vehicleNumber":"ajshd","vehicleModel":"dka","vehicleType":"FourWheeler","vehicleBrand":"hyundai","vehicleColor":"black","parkingCostType":"daily"}}
 
 GET localhost:8080/parking/{parkingId}/exit
 Purpose : To generate Reciept of cost of parking of vehicle. This api will be used when a person is exiting the parking space
 Response: {"id":"c32f73d9-e600-460c-ac9a-947b681c597c","vehicle":{"hourlyParkingCost":100,"dailyParkingCost":300,"vehicleType":"FourWheeler"},"parkingTime":"2020-07-25T14:51:48.931+00:00","exitTime":"2020-07-25T14:53:04.078+00:00","parkingSpaceId":"2","parkingCostType":"daily","cost":300,"vehicleInfo":{"vehicleNumber":"ajshd","vehicleModel":"dka","vehicleType":"FourWheeler","vehicleBrand":"hyundai","vehicleColor":"black","parkingCostType":"daily"}}
 
 GET localhost:8080/parking/report
 Purpose : The api will tell you that how many empty and used parking are present at the moment. Apart from that this also tells the detail about used parking.
 Response: {"totalParkingAvailable":10,"totalUsedParking":0,"usedParkingList":[]}
 
 GET localhost:8080/parking/report/historical
 Purpose : This api will provide you the detail of all the reciept generated in past. This can be used for various other purposes.
 Response : [{"id":"c32f73d9-e600-460c-ac9a-947b681c597c","vehicle":{"hourlyParkingCost":100,"dailyParkingCost":300,"vehicleType":"FourWheeler"},"parkingTime":"2020-07-25T14:51:48.931+00:00","exitTime":"2020-07-25T14:53:04.078+00:00","parkingSpaceId":"2","parkingCostType":"daily","cost":300,"vehicleInfo":{"vehicleNumber":"ajshd","vehicleModel":"dka","vehicleType":"FourWheeler","vehicleBrand":"hyundai","vehicleColor":"black","parkingCostType":"daily"}},{"id":"98873eda-3c08-4625-b6c6-0a045d02078e","vehicle":{"hourlyParkingCost":100,"dailyParkingCost":300,"vehicleType":"FourWheeler"},"parkingTime":"2020-07-25T14:34:42.526+00:00","exitTime":"2020-07-25T14:34:55.582+00:00","parkingSpaceId":"1","parkingCostType":"daily","cost":300,"vehicleInfo":{"vehicleNumber":"ajshd","vehicleModel":"dka","vehicleType":"FourWheeler","vehicleBrand":"hyundai","vehicleColor":"black","parkingCostType":"daily"}}]
 
 
{
  "swagger" : "2.0",
  "info" : {
    "description" : "This project is Parking System and We are describing what functionalities we have provided in it.\n",
    "version" : "1.0.0",
    "title" : "Parking System",
    "contact" : {
      "email" : "naresh.acet@gmail.com"
    }
  },
  "basePath" : "/",
  "tags" : [ {
    "name" : "parking",
    "description" : "Complete Parking System Solution"
  } ],
  "schemes" : [ "http" ],
  "paths" : {
    "/parking/allot" : {
      "post" : {
        "tags" : [ "parking" ],
        "summary" : "Allot new parking to Vehicle",
        "description" : "This API is used for Alloting New Parking to a Vehicle",
        "operationId" : "allotParking",
        "produces" : [ "application/json", "application/xml" ],
        "parameters" : [ {
          "name" : "vehicleNumber",
          "in" : "query",
          "description" : "We need to provide value of Vehicle Number if present",
          "required" : false,
          "type" : "string"
        }, {
          "name" : "vehicleModel",
          "in" : "query",
          "description" : "We need to provide Model of Vehicle if Its Present",
          "required" : false,
          "type" : "string"
        }, {
          "name" : "vehicleBrand",
          "in" : "query",
          "description" : "We need to provide Brand(Company) of Vehicle if Its Present",
          "required" : false,
          "type" : "string"
        }, {
          "name" : "vehicleColor",
          "in" : "query",
          "description" : "We need to provide Color of Vehicle if Its Present",
          "required" : false,
          "type" : "string"
        }, {
          "name" : "vehicleType",
          "in" : "query",
          "description" : "We need to provide Type of Vehicle",
          "required" : true,
          "type" : "string",
          "enum" : [ "FourWheeler", "TwoWheeler", "ThreeWheeler" ]
        }, {
          "name" : "parkingCostType",
          "in" : "query",
          "description" : "We need to provide Type of Costing for Parking by default its Hourly",
          "required" : false,
          "type" : "string",
          "default" : "hourly",
          "enum" : [ "daily", "hourly" ]
        } ],
        "responses" : {
          "200" : {
            "description" : "successful operation",
            "schema" : {
              "type" : "object"
            }
          },
          "400" : {
            "description" : "Invalid Data Mostly"
          }
        }
      }
    },
    "/parking/{parkingId}/exit" : {
      "get" : {
        "tags" : [ "parking" ],
        "summary" : "Call this api when a vehicle is exiting from the parking space",
        "description" : "This api generate a reciept of a vehicle parking charges on the basis of different cost parameter.",
        "operationId" : "exitVehicle",
        "produces" : [ "application/json", "application/xml" ],
        "parameters" : [ {
          "name" : "parkingId",
          "in" : "query",
          "description" : "Provide ParkingId of the vehicle which wanted to exit from parking space",
          "required" : true,
          "type" : "string"
        } ],
        "responses" : {
          "200" : {
            "description" : "successful operation",
            "schema" : {
              "type" : "object"
            }
          },
          "400" : {
            "description" : "Invalid Data Mostly"
          }
        }
      }
    },
    "/parking/report" : {
      "get" : {
        "tags" : [ "parking" ],
        "summary" : "This api gives you the result of all the parking which are being used and the number of used and empty parkings.",
        "description" : "This api gives you the result of all the parking which are being used and the number of used and empty parkings.",
        "operationId" : "getReport",
        "produces" : [ "application/json", "application/xml" ],
        "parameters" : [ ],
        "responses" : {
          "200" : {
            "description" : "successful operation",
            "schema" : {
              "type" : "object"
            }
          },
          "400" : {
            "description" : "Invalid Data Mostly"
          }
        }
      }
    },
    "/parking/report/historical" : {
      "get" : {
        "tags" : [ "parking" ],
        "summary" : "This api gives you the result of all the parking reciepts which are used in past to generate different kind of reports.",
        "description" : "This api gives you the result of all the parking reciepts which are used in past to generate different kind of reports.",
        "operationId" : "getHistoricalReport",
        "produces" : [ "application/json", "application/xml" ],
        "parameters" : [ ],
        "responses" : {
          "200" : {
            "description" : "successful operation"
          },
          "400" : {
            "description" : "Invalid Data Mostly"
          }
        }
      }
    }
  },
  "definitions" : {
    "/parking Response Model" : {
      "type" : "object",
      "properties" : {
        "parkingId" : {
          "type" : "string"
        },
        "parkingSpaceId" : {
          "type" : "string"
        },
        "vehicle" : {
          "type" : "object",
          "properties" : { }
        },
        "parkingTime" : {
          "type" : "string"
        },
        "parkingCostType" : {
          "type" : "string",
          "enum" : [ "daily", "hourly" ]
        },
        "vehicleInfo" : {
          "type" : "object",
          "properties" : { }
        }
      }
    }
  }
}