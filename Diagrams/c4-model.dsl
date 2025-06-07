workspace "Software Design & Patterns - C4 Model - MecanoCraft" "Vehicle Monitoring System in Mechanical Repair Shops" {
    model {
        # People
        vehicle_owner = person "Vehicle Owner" "Owner of one or more vehicles." {
            tags "Vehicle Owner"
        }
        workshop_admin = person "Workshop Administrator" "Manager or owner of a Workshop." {
            tags "Workshop Admin"
        }

        # Software System (MecanicHub)
        monitoringSystem = softwareSystem "Vehicle Monitoring System in Mechanical Repair Shops" "It allows vehicle owners to monitor the status of their vehicle and communicate with the workshop." {
            tags "Monitoring System"

        # Containers
        mobileApplication = container "Mobile App" "Permite a los usuarios visualizar un dashboard con el resumen de toda la información del traslado de los lotes de vacunas." "Swift UI" "mobile" {
            tags "Mobile Browser"
        }
        webApplication = container "Web App" "Permite a los usuarios visualizar un dashboard con el resumen de toda la información del traslado de los lotes de vacunas." "React" "web" {
            tags "Web Browser"
        }
        landingPage = container "Landing Page" "" "React" "landing" {
            tags "Landing"
        }
        apiRest = container "API REST" "API REST" "NodeJS (NestJS) port 8080" "apirest" {
            tags "API"
            
            # General
            flights = component "Flights" "" "NodeJS(NestJS)" {
                tags "All"
            }
            airports = component "Airports" "" "NodeJS(NestJS)" {
                tags "All"
            }
            aircrafts = component "Aircrafts" "" "NodeJS(NestJS)" {
                tags "All"
            }
            security = component "Security" "" "NodeJS(NestJS)" {
                tags "All"
            }
            vaccines = component "Vaccines" "" "NodeJS(NestJS)" {
                tags "All"
            }
            monitoring = component "Monitoring" "" "NodeJS(NestJS)" {
                tags "All"
            }
            sharedKernel = component "Shared Kernel" "" "NodeJS(NestJS)" {
                tags "All"
            }
            
            # Flights BC
            flightInterface = component "Interface Layer Flights" "" "NodeJS(NestJS)" {
                tags "FlightsBC"
            }
            flightApplication = component "Application Layer Flights" "" "NodeJS(NestJS)" {
                tags "FlightsBC"
            }
            flightInfrastructure = component "Infrastructure Layer Flights" "" "NodeJS(NestJS)" {
                tags "FlightsBC"
            }
            flightDomain = component "Domain Layer Flights" "" "NodeJS(NestJS)" {
                tags "FlightsBC"
            }
            
            # Aircrafts BC
            aircraftsInterface = component "Interface Layer Aircrafts" "" "NodeJS(NestJS)" {
                tags "AircraftsBC"
            }
            aircraftsApplication = component "Application Layer Aircrafts" "" "NodeJS(NestJS)" {
                tags "AircraftsBC"
            }
            aircraftsInfrastructure = component "Infrastructure Layer Aircrafts" "" "NodeJS(NestJS)" {
                tags "AircraftsBC"
            }
            aircraftsDomain = component "Domain Layer Aircrafts" "" "NodeJS(NestJS)" {
                tags "AircraftsBC"
            }
            
            # Airports BC
            airportsInterface = component "Interface Layer Airports" "" "NodeJS(NestJS)" {
                tags "AirportsBC"
            }
            airportsApplication = component "Application Layer Airports" "" "NodeJS(NestJS)" {
                tags "AirportsBC"
            }
            airportsInfrastructure = component "Infrastructure Layer Airports" "" "NodeJS(NestJS)" {
                tags "AirportsBC"
            }
            airportsDomain = component "Domain Layer Airports" "" "NodeJS(NestJS)" {
                tags "AirportsBC"
            }
            
            # Security BC
            securityInterface = component "Interface Layer Security" "" "NodeJS(NestJS)" {
                tags "SecurityBC"
            }
            securityApplication = component "Application Layer Security" "" "NodeJS(NestJS)" {
                tags "SecurityBC"
            }
            securityInfrastructure = component "Infrastructure Layer Security" "" "NodeJS(NestJS)" {
                tags "SecurityBC"
            }
            securityDomain = component "Domain Layer Security" "" "NodeJS(NestJS)" {
                tags "SecurityBC"
            }
            securityComponent = component "Security Component" "" "NodeJS(NestJS)" {
                tags "SecurityBC"
            }
            
            # Vaccines BC
            vaccinesInterface = component "Interface Layer Vaccines" "" "NodeJS(NestJS)" {
                tags "VaccinesBC"
            }
            vaccinesApplication = component "Application Layer Vaccines" "" "NodeJS(NestJS)" {
                tags "VaccinesBC"
            }
            vaccinesInfrastructure = component "Infrastructure Layer Vaccines" "" "NodeJS(NestJS)" {
                tags "VaccinesBC"
            }
            vaccinesDomain = component "Domain Layer Vaccines" "" "NodeJS(NestJS)" {
                tags "VaccinesBC"
            }
            
            # Monitoring BC
            monitoringInterface = component "Interface Layer Monitoring" "" "NodeJS(NestJS)" {
                tags "MonitoringBC"
            }
            monitoringApplication = component "Application Layer Monitoring" "" "NodeJS(NestJS)" {
                tags "MonitoringBC"
            }
            monitoringInfrastructure = component "Infrastructure Layer Monitoring" "" "NodeJS(NestJS)" {
                tags "MonitoringBC"
            }
            monitoringDomain = component "Domain Layer Monitoring" "" "NodeJS(NestJS)" {
                tags "MonitoringBC"
            }
            monitoringConnector = component "Google Maps Connector" "" "NodeJS(NestJS)" {
                tags "MonitoringBC"
            }
            
        }
        
        database = container "DB" "" "MySQL Server RDS AWS" "database" {
            tags "Database"
        }
        
    }
    
    # Software Systems
    GoogleMaps = softwareSystem "Google Maps" "Platform that offers a REST API for georeferenced information" {
        tags "Google Maps"
    }
    EmailSystem = softwareSystem "Email System" "The internal Microsoft Exchange e-mail system" {
        tags "Email System"
    }
    OAuthProvider = softwareSystem "OAuth Provider" "Authentication services such as Google or Facebook." {
        tags "OAuth Provider"
    }
    PaymentSystem = softwareSystem "Payment System" "Payment processing services" {
        tags "Payment System"
    }
    SunatDatabase = softwareSystem "SUNAT" "Database for RUC validation" {
        tags "Sunat System"
    }
    SunarpDatabase = softwareSystem "SUNARP" "Database for vehicle ownership validation" {
        tags "Sunarp System"
    }


    # Relationships between people and system
    workshop_admin -> monitoringSystem "Manage the workshop, administer customer appointments, staff, and all services."
    vehicle_owner -> monitoringSystem "Search for workshops, request service, schedule an appointment, and monitor your vehicle throughout the entire process."
    
    # Relation between systems
    monitoringSystem -> GoogleMaps "Use Google Maps API"
    monitoringSystem -> EmailSystem "Send emails to users using [SMTP]"
    monitoringSystem -> OAuthProvider "Authenticate users using OAuth2"
    monitoringSystem -> PaymentSystem "Manage payments for services"
    monitoringSystem -> SunatDatabase "Validate RUCs for customers using SUNAT Database"
    monitoringSystem -> SunarpDatabase "Validate vehicle ownership using SUNARP Database"

    # Relationships between containers
    vehicle_owner -> mobileApplication "Consulta"
    vehicle_owner -> landingPage "Consulta"
    vehicle_owner -> webApplication "Consulta"
    workshop_admin -> mobileApplication "Consulta"
    workshop_admin -> landingPage "Consulta"
    workshop_admin -> webApplication "Consulta"
    
    mobileApplication -> apiRest "API Request" "JSON/HTTPS"
    webApplication -> apiRest "API Request" "JSON/HTTPS"
    apiRest -> database
    apiRest -> GoogleMaps "API Request" "JSON/HTTPS"

    # Component-level relationships (within API Application)
    # General
    flights -> sharedKernel "Usa"
    airports -> sharedKernel "Usa"
    aircrafts -> sharedKernel "Usa"
    security -> sharedKernel "Usa"
    vaccines -> sharedKernel "Usa"
    monitoring -> sharedKernel "Usa"
    
    flights -> database "Usa"
    airports -> database "Usa"
    aircrafts -> database "Usa"
    security -> database "Usa"
    vaccines -> database "Usa"
    monitoring -> database "Usa"
    
    monitoring -> GoogleMaps "Usa"
    
    # Flights
    flightInterface -> flightApplication
    flightApplication -> flightDomain 
    flightApplication -> flightInfrastructure
    flightInfrastructure -> flightDomain
    flightInfrastructure -> database "Usa"
    
    # Aircrafts
    aircraftsInterface -> aircraftsApplication
    aircraftsApplication -> aircraftsDomain 
    aircraftsApplication -> aircraftsInfrastructure
    aircraftsInfrastructure -> aircraftsDomain
    aircraftsInfrastructure -> database "Usa"
    
    # Airports
    airportsInterface -> airportsApplication
    airportsApplication -> airportsDomain 
    airportsApplication -> airportsInfrastructure
    airportsInfrastructure -> airportsDomain
    airportsInfrastructure -> database "Usa"
    
    # Security
    securityInterface -> securityApplication
    securityApplication -> securityDomain 
    securityApplication -> securityInfrastructure
    securityInfrastructure -> securityDomain
    securityInfrastructure -> securityComponent
    securityInfrastructure -> database "Usa"
    
    # Vaccines
    vaccinesInterface -> vaccinesApplication
    vaccinesApplication -> vaccinesDomain 
    vaccinesApplication -> vaccinesInfrastructure
    vaccinesInfrastructure -> vaccinesDomain
    vaccinesInfrastructure -> database "Usa"
    
    # Monitoring
    monitoringInterface -> monitoringApplication
    monitoringApplication -> monitoringDomain 
    monitoringApplication -> monitoringInfrastructure
    monitoringInfrastructure -> monitoringDomain
    monitoringInfrastructure -> monitoringConnector
    monitoringConnector -> GoogleMaps "[JSON/HTTPS]"
    monitoringInfrastructure -> database "Usa"
    
    }

    views {
        systemContext monitoringSystem "SystemContext" "Diagrama de Contexto" {
        include *
        autoLayout tb
    }

    container monitoringSystem "Containers" "Monitoreo del Traslado Aéreo de Vacunas SARS-CoV-2" {
        include *
        autoLayout tb
    }

    component apiRest "Components" "API Rest Component Diagram" {
        include "element.tag==All"
        include database GoogleMaps
        autoLayout tb
        title "API Rest Component Diagram"
    }
    
    component apiRest "AircraftsBC" "Aircrafts BC Component Diagram" {
        include "element.tag==AircraftsBC"
        include database
        autoLayout tb
        title "Aircraft BC Component Diagram"
    }
    
    component apiRest "FlightsBC" "Flights BC Component Diagram" {
        include "element.tag==FlightsBC"
        include database
        autoLayout tb
        title "Flights BC Component Diagram"
    }
    
    component apiRest "AirportsBC" "Airports BC Component Diagram" {
        include "element.tag==AirportsBC"
        include database
        autoLayout tb
        title "Airports BC Component Diagram"
    }
    
    component apiRest "SecurityBC" "Security BC Component Diagram" {
        include "element.tag==SecurityBC"
        include database
        autoLayout tb
        title "Security BC Component Diagram"
    }
    
    component apiRest "VaccinesBC" "Vaccines BC Component Diagram" {
        include "element.tag==VaccinesBC"
        include database
        autoLayout tb
        title "Vaccines BC Component Diagram"
    }
    
    component apiRest "MonitoringBC" "Monitoring BC Component Diagram" {
        include "element.tag==MonitoringBC"
        include database GoogleMaps
        autoLayout tb
        title "Monitoring BC Component Diagram"
    }

    styles {
        element "Workshop Admin" {
        shape "Person"
        background "#293241"
        color "#ffffff"
        }
        element "Vehicle Owner" {
        shape "Person"
        background "#ee6c4d"
        color "#ffffff"
        }
        element "Monitoring System" {
        background "#008f39"
        color "#ffffff"
        }
         element "Google Maps" {
        background "#90714c"
        color "#ffffff"
        }
         element "Aircraft System" {
        background "#2f95c7"
        color "#ffffff"
        }
        element "Mobile Browser" {
        background "#9d33d6"
        color "#ffffff"
        }
        element "Web Browser" {
        shape "WebBrowser"
        background "#9d33d6"
        color "#ffffff"
        }
        element "Landing" {
        background "#929000"
        color "#ffffff"
        }
        element "API" {
        background "#0000ff"
        color "#ffffff"
        }
        element "Database" {
        shape "Cylinder"
        background "#ff0000"
        color "#ffffff"
        }
        element "Component" {
            shape component
            background "#facc2e"
            color "#000000"
        }
    }

    theme default
    }

    properties {
        structurizr.groupSeparator "/"
    }
}