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
        mobileApplication = container "Mobile App" "Allows monitoring of the user's vehicle and constant communication with the workshop" "Flutter" "mobile" {
            tags "Mobile Browser"
        }
        webApplication = container "Web App" "Allows monitoring of the user's vehicle and constant communication with the workshop" "Vue.js" "web" {
            tags "Web Browser"
        }
        landingPage = container "Landing Page" "Allows the user to be informed about the services offered by MecanicHub" "Vue.js" "landing" {
            tags "Landing"
        }
        apiRest = container "API REST" "Provides access to vehicle monitoring data and communication endpoints" "Java and Spring Boot" "apirest" {
            tags "API"
            
            # General
            appointments = component "Appointments" "" "NodeJS(NestJS)" {
                tags "All"
            }
            workshops = component "Workshops" "" "NodeJS(NestJS)" {
                tags "All"
            }
            notification = component "Notification" "" "NodeJS(NestJS)" {
                tags "All"
            }
            authentication = component "Authentication" "" "NodeJS(NestJS)" {
                tags "All"
            }
            payments = component "Payments" "" "NodeJS(NestJS)" {
                tags "All"
            }
            monitoring = component "Monitoring" "" "NodeJS(NestJS)" {
                tags "All"
            }
            sharedKernel = component "Shared Kernel" "" "NodeJS(NestJS)" {
                tags "All"
            }

            # Appointments BC
            appointmentsInterface = component "Interface Layer Appointments" "" "NodeJS(NestJS)" {
                tags "AppointmentsBC"
            }
            appointmentsApplication = component "Application Layer Appointments" "" "NodeJS(NestJS)" {
                tags "AppointmentsBC"
            }
            appointmentsInfrastructure = component "Infrastructure Layer Appointments" "" "NodeJS(NestJS)" {
                tags "AppointmentsBC"
            }
            appointmentsDomain = component "Domain Layer Appointments" "" "NodeJS(NestJS)" {
                tags "AppointmentsBC"
            }

            # Workshops BC
            workshopsInterface = component "Interface Layer Workshops" "" "NodeJS(NestJS)" {
                tags "WorkshopsBC"
            }
            workshopsApplication = component "Application Layer Workshops" "" "NodeJS(NestJS)" {
                tags "WorkshopsBC"
            }
            workshopsInfrastructure = component "Infrastructure Layer Workshops" "" "NodeJS(NestJS)" {
                tags "WorkshopsBC"
            }
            workshopsDomain = component "Domain Layer Workshops" "" "NodeJS(NestJS)" {
                tags "WorkshopsBC"
            }

            # Notification BC
            notificationInterface = component "Interface Layer Notification" "" "NodeJS(NestJS)" {
                tags "NotificationBC"
            }
            notificationApplication = component "Application Layer Notification" "" "NodeJS(NestJS)" {
                tags "NotificationBC"
            }
            notificationInfrastructure = component "Infrastructure Layer Notification" "" "NodeJS(NestJS)" {
                tags "NotificationBC"
            }
            notificationDomain = component "Domain Layer Notification" "" "NodeJS(NestJS)" {
                tags "NotificationBC"
            }
            notificationComponent = component "Notification Component" "" "NodeJS(NestJS)" {
                tags "NotificationBC"
            }

            # Authentication BC
            authenticationInterface = component "Interface Layer Authentication" "" "NodeJS(NestJS)" {
                tags "AuthenticationBC"
            }
            authenticationApplication = component "Application Layer Authentication" "" "NodeJS(NestJS)" {
                tags "AuthenticationBC"
            }
            authenticationInfrastructure = component "Infrastructure Layer Authentication" "" "NodeJS(NestJS)" {
                tags "AuthenticationBC"
            }
            authenticationDomain = component "Domain Layer Authentication" "" "NodeJS(NestJS)" {
                tags "AuthenticationBC"
            }

            # Payments BC
            paymentsInterface = component "Interface Layer Payments" "" "NodeJS(NestJS)" {
                tags "PaymentsBC"
            }
            paymentsApplication = component "Application Layer Payments" "" "NodeJS(NestJS)" {
                tags "PaymentsBC"
            }
            paymentsInfrastructure = component "Infrastructure Layer Payments" "" "NodeJS(NestJS)" {
                tags "PaymentsBC"
            }
            paymentsDomain = component "Domain Layer Payments" "" "NodeJS(NestJS)" {
                tags "PaymentsBC"
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
        
        database = container "DB" "Store user registration information, authentication credentials, access logs, etc." "MySQL Server RDS AWS" "database" {
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
    vehicle_owner -> mobileApplication "Uses"
    vehicle_owner -> landingPage "Uses"
    vehicle_owner -> webApplication "Uses" "HTTPS"
    workshop_admin -> mobileApplication "Uses"
    workshop_admin -> landingPage "Uses"
    workshop_admin -> webApplication "Uses" "HTTPS"

    mobileApplication -> apiRest "API Request" "JSON/HTTPS"
    webApplication -> apiRest "API Request" "JSON/HTTPS"
    apiRest -> database "Read from and write to" "MySQL"
    apiRest -> GoogleMaps "API Request" "JSON/HTTPS"
    apiRest -> EmailSystem "API Request" "JSON/HTTPS"
    apiRest -> OAuthProvider "API Request" "JSON/HTTPS"
    apiRest -> PaymentSystem "API Request" "JSON/HTTPS"
    apiRest -> SunatDatabase "API Request" "JSON/HTTPS"
    apiRest -> SunarpDatabase "API Request" "JSON/HTTPS"

    # Component-level relationships (within API Application)
    # General
    appointments -> sharedKernel "Usa"
    workshops -> sharedKernel "Usa"
    notification -> sharedKernel "Usa"
    authentication -> sharedKernel "Usa"
    payments -> sharedKernel "Usa"
    monitoring -> sharedKernel "Usa"
    
    appointments -> database "Usa"
    workshops -> database "Usa"
    notification -> database "Usa"
    authentication -> database "Usa"
    payments -> database "Usa"
    monitoring -> database "Usa"
    
    appointments -> GoogleMaps "Usa"
    workshops -> SunarpDatabase "Usa"
    workshops -> SunatDatabase "Usa"
    authentication -> OAuthProvider "Usa"
    payments -> PaymentSystem "Usa"
    monitoring -> EmailSystem "Usa"
    notification -> EmailSystem "Usa"
    
    # appointments
    appointmentsInterface -> appointmentsApplication
    appointmentsApplication -> appointmentsDomain 
    appointmentsApplication -> appointmentsInfrastructure
    appointmentsInfrastructure -> appointmentsDomain
    appointmentsInfrastructure -> database "Usa"

    # workshops
    workshopsInterface -> workshopsApplication
    workshopsApplication -> workshopsDomain 
    workshopsApplication -> workshopsInfrastructure
    workshopsInfrastructure -> workshopsDomain
    workshopsInfrastructure -> database "Usa"
    workshopsInfrastructure -> SunarpDatabase "Usa"
    workshopsInfrastructure -> SunatDatabase "Usa"

    # Notification
    notificationInterface -> notificationApplication
    notificationApplication -> notificationDomain 
    notificationApplication -> notificationInfrastructure
    notificationInfrastructure -> notificationDomain
    notificationInfrastructure -> notificationComponent
    notificationInfrastructure -> database "Usa"
    notificationInfrastructure -> EmailSystem "Usa"

    # authentication
    authenticationInterface -> authenticationApplication
    authenticationApplication -> authenticationDomain 
    authenticationApplication -> authenticationInfrastructure
    authenticationInfrastructure -> authenticationDomain
    authenticationInfrastructure -> database "Usa"
    authenticationInfrastructure -> OAuthProvider "Usa"
    
    # Payments
    paymentsInterface -> paymentsApplication
    paymentsApplication -> paymentsDomain 
    paymentsApplication -> paymentsInfrastructure
    paymentsInfrastructure -> paymentsDomain
    paymentsInfrastructure -> database "Usa"
    paymentsInfrastructure -> PaymentSystem "Usa"

    # Monitoring
    monitoringInterface -> monitoringApplication
    monitoringApplication -> monitoringDomain 
    monitoringApplication -> monitoringInfrastructure
    monitoringInfrastructure -> monitoringDomain
    monitoringInfrastructure -> monitoringConnector
    monitoringConnector -> GoogleMaps "[JSON/HTTPS]"
    monitoringInfrastructure -> database "Usa"
    monitoringInfrastructure -> EmailSystem "Usa"
    
    }

    views {
    systemContext monitoringSystem "SystemContext" "Diagrama de Contexto" {
        include *
        autoLayout tb
    }

    container monitoringSystem "Containers-Vertical" "Diagrama de Contenedores" {
        include *
        autoLayout tb
    }

    component apiRest "Components" "API Rest Component Diagram" {
        include "element.tag==All"
        include database GoogleMaps EmailSystem OAuthProvider PaymentSystem SunatDatabase SunarpDatabase
        autoLayout tb
        title "API Rest Component Diagram"
    }

    component apiRest "Appointments" "Appointments BC Component Diagram" {
        include "element.tag==AppointmentsBC"
        include database
        autoLayout tb
        title "Appointments BC Component Diagram"
    }

    component apiRest "WorkshopsBC" "Workshops BC Component Diagram" {
        include "element.tag==WorkshopsBC"
        include database SunarpDatabase SunatDatabase
        autoLayout tb
        title "Workshops BC Component Diagram"
    }

    component apiRest "AuthenticationBC" "Authentication BC Component Diagram" {
        include "element.tag==AuthenticationBC"
        include database OAuthProvider
        autoLayout tb
        title "Authentication BC Component Diagram"
    }

    component apiRest "NotificationBC" "Notification BC Component Diagram" {
        include "element.tag==NotificationBC"
        include database EmailSystem
        autoLayout tb
        title "Notification BC Component Diagram"
    }

    component apiRest "PaymentsBC" "Payments BC Component Diagram" {
        include "element.tag==PaymentsBC"
        include database PaymentSystem
        autoLayout tb
        title "Payments BC Component Diagram"
    }
    
    component apiRest "MonitoringBC" "Monitoring BC Component Diagram" {
        include "element.tag==MonitoringBC"
        include database GoogleMaps EmailSystem
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
            background "#3d5a80"
            color "#ffffff"
        }
        element "Google Maps" {
            background "#90714c"
            color "#ffffff"
        }
        element "Email System" {
            background "#0E46D3"
            color "#ffffff"
        }
        element "OAuth Provider" {
            background "#21A4D8"
            color "#ffffff"
        }
        element "Payment System" {
            background "#308E20"
            color "#ffffff"
        }
        element "Sunat System" {
            background "#BE4027"
            color "#ffffff"
        }
        element "Sunarp System" {
            background "#CAC527"
            color "#ffffff"
        }
        element "Mobile Browser" {
            background "#63caf8"
            color "#ffffff"
        }
        element "Web Browser" {
            shape "WebBrowser"
            background "#47ba87"
            color "#ffffff"
        }
        element "Landing" {
            background "#3a4f63"
            color "#ffffff"
        }
        element "API" {
            background "#72b545"
            color "#ffffff"
        }
        element "Database" {
            shape "Cylinder"
            background "#086690"
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