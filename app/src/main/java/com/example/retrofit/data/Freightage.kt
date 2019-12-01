package com.example.retrofit.data

import com.google.gson.annotations.SerializedName

class Freightage(
    @SerializedName("id")
    val id: String,
    @SerializedName("transportadora_id")
    val conveyorId: Int,
    @SerializedName("cargador_id")
    val chargerId: Int,
    @SerializedName("origen_id")
    val originId: Int,
    @SerializedName("destino_id")
    val destinationId: Int,
    @SerializedName("vigencia")
    val validity: String
)

/*
{
    "id": 3,
    "transportadora_id": 7,
    "cargador_id": 4,
    "origen_id": 1,
    "destino_id": 3,
    "carga_id": 1,
    "factura": "",
    "crt": "",
    "cantidad_transportadora": "100.000",
    "unidad_transportadora_id": 2,
    "tarifa_transportadora": "100000.00",
    "tax_transportadora": null,
    "moneda_transportadora_id": 1,
    "cantidad_transportista": "100000.000",
    "unidad_transportista_id": 1,
    "tarifa_transportista": "95.00",
    "tax_transportista": null,
    "moneda_transportista_id": 1,
    "anticipo_efectivo": "20.00",
    "anticipo_combustible": "60.00",
    "detalles": "",
    "indicacion_origen_destino": {
        "distancia_km": "50",
        "indicacion_origen": "",
        "indicacion_destino": ""
    },
    "aviso_legal_id": 1,
    "vigencia": "2019-02-09",
    "publicado": true,
    "cancelado": false,
    "subasta_id": null,
    "equivalencia_transportadora": "1000.00",
    "equivalencia_transportista": "1.00",
    "created_at": "2019-02-11 14:28:14",
    "updated_at": "2019-02-11 14:28:31",
    "deleted_at": null,
    "tipo_flete": "Doméstico",
    "distancia_km": "50",
    "indicacion_origen": "",
    "indicacion_destino": "",
    "unidad_merma_transportadora_id": "1",
    "unidad_merma_transportista_id": "1",
    "telefono": null,
    "merma": {
        "flete_id": 3,
        "es_porcentual_transportadora": true,
        "tolerancia_transportadora": "0.015",
        "unidad_transportadora_id": 1,
        "valor_transportadora": "2000.00",
        "moneda_transportadora_id": 1,
        "tax_transportadora": null,
        "es_porcentual_transportista": true,
        "tolerancia_transportista": "0.010",
        "unidad_transportista_id": 1,
        "valor_transportista": "2500.00",
        "moneda_transportista_id": 1,
        "tax_transportista": null,
        "equivalencia_transportadora": "1.00",
        "equivalencia_transportista": "1.00",
        "created_at": "2019-02-11 14:28:14",
        "updated_at": "2019-02-11 14:28:24",
        "deleted_at": null,
        "unidad_transportista": {
            "id": 1,
            "nombre": "Kilogramos",
            "abreviatura": "KG",
            "valor_kg": 1,
            "transportadora_id": null,
            "created_at": null,
            "updated_at": null,
            "deleted_at": null
        },
        "moneda_transportista": {
            "id": 1,
            "nombre": "Guaranies",
            "simbolo": "PYG",
            "es_moderado": true,
            "created_at": null,
            "updated_at": null,
            "deleted_at": null
        }
    },
    "transportadora": {
        "id": 7,
        "nombre": "TRANSRED",
        "nombre_corto": "TRD",
        "documento": "80015858-0",
        "tipo_entidad": "Transportadora",
        "direccion": "Defensores del Chaco c/Sta. Teresa",
        "ciudad_id": 66,
        "latlon": {
            "latitud": "-25.3739192",
            "longitud": "-57.60516960000001"
        },
        "contacto": {
            "url": "",
            "contactos": [],
            "informacion_adicional": "<p>Transportamos lo que mas le importa a Ud.! Su carga!!</p>"
        },
        "tipo_documento_id": 2,
        "persona_juridica_id": 1,
        "user_id": 19,
        "created_at": "2019-02-08 14:35:43",
        "updated_at": "2019-02-08 14:35:43",
        "deleted_at": null,
        "latitud": "-25.3739192",
        "longitud": "-57.60516960000001",
        "url": "",
        "contactos": [],
        "informacion_adicional": "<p>Transportamos lo que mas le importa a Ud.! Su carga!!</p>",
        "activar_usuario": true,
        "email": "walterb@transred.com.py",
        "usuario": "TRD",
        "nombres": "TRD",
        "apellidos": "Admin",
        "admin": {
            "id": 19,
            "first_name": "TRD",
            "last_name": "Admin",
            "login": "TRD",
            "email": "walterb@transred.com.py",
            "permissions": null,
            "is_activated": false,
            "role_id": 5,
            "activated_at": null,
            "last_login": "2019-11-28 13:21:00",
            "created_at": "2019-02-08 14:35:43",
            "updated_at": "2019-11-30 08:45:57",
            "is_superuser": false,
            "last_activity": "2019-11-28 13:28:18"
        },
        "logo": {
            "id": 33,
            "disk_name": "5c5dbd1cb186b362337531.jpg",
            "file_name": "TRD Simple.jpg",
            "file_size": 35404,
            "content_type": "image/jpeg",
            "title": null,
            "description": null,
            "field": "logo",
            "sort_order": 33,
            "created_at": "2019-02-08 14:32:12",
            "updated_at": "2019-02-08 14:35:43",
            "path": "http://charger.icargo.co/storage/app/uploads/public/5c5/dbd/1cb/5c5dbd1cb186b362337531.jpg",
            "extension": "jpg"
        },
        "ciudad": {
            "id": 66,
            "nombre": " Villa Elisa",
            "localidad_id": 8,
            "localidad": {
                "id": 8,
                "nombre": " Central",
                "pais_id": 1,
                "pais": {
                    "id": 1,
                    "nombre": "Paraguay"
                }
            }
        }
    },
    "cargador": {
        "id": 4,
        "nombre": "CARGILL AGROPECUARIA",
        "nombre_corto": "CGLL_PY",
        "documento": "80005966-2",
        "tipo_entidad": "Cargador",
        "direccion": "Av. San Blas Km 2",
        "ciudad_id": 14,
        "latlon": {
            "latitud": "-25.510348990559436",
            "longitud": "-54.62528380861818"
        },
        "contacto": {
            "url": "",
            "contactos": [],
            "informacion_adicional": ""
        },
        "tipo_documento_id": 2,
        "persona_juridica_id": 3,
        "user_id": null,
        "created_at": "2019-02-08 14:11:40",
        "updated_at": "2019-02-08 14:14:10",
        "deleted_at": null,
        "latitud": "-25.510348990559436",
        "longitud": "-54.62528380861818",
        "url": "",
        "contactos": [],
        "informacion_adicional": "",
        "activar_usuario": false,
        "logo": {
            "id": 26,
            "disk_name": "5c5db8ae1ea9d329550359.jpg",
            "file_name": "cargill.jpg",
            "file_size": 4675,
            "content_type": "image/jpeg",
            "title": null,
            "description": null,
            "field": "logo",
            "sort_order": 26,
            "created_at": "2019-02-08 14:13:18",
            "updated_at": "2019-02-08 14:13:20",
            "path": "http://charger.icargo.co/storage/app/uploads/public/5c5/db8/ae1/5c5db8ae1ea9d329550359.jpg",
            "extension": "jpg"
        },
        "ciudad": {
            "id": 14,
            "nombre": " Ciudad del Este",
            "localidad_id": 2,
            "localidad": {
                "id": 2,
                "nombre": " Alto Parana",
                "pais_id": 1,
                "pais": {
                    "id": 1,
                    "nombre": "Paraguay"
                }
            }
        }
    },
    "origen": {
        "id": 1,
        "nombre": "CARGILL CEDRALES",
        "nombre_corto": null,
        "documento": null,
        "tipo_entidad": "Centro Operativo",
        "direccion": "CEDRALES",
        "ciudad_id": 13,
        "latlon": {
            "latitud": "-25.658948139894708",
            "longitud": "-54.717514329980474"
        },
        "contacto": {
            "url": null,
            "contactos": [],
            "informacion_adicional": null
        },
        "tipo_documento_id": null,
        "persona_juridica_id": null,
        "user_id": null,
        "created_at": "2019-02-08 14:02:19",
        "updated_at": "2019-02-08 14:42:28",
        "deleted_at": null,
        "latitud": "-25.658948139894708",
        "longitud": "-54.717514329980474",
        "url": null,
        "contactos": [],
        "informacion_adicional": null,
        "activar_usuario": false,
        "logo": {
            "id": 30,
            "disk_name": "5c5dbb3061c04761099984.png",
            "file_name": "Icono.png",
            "file_size": 3374,
            "content_type": "image/png",
            "title": null,
            "description": null,
            "field": "logo",
            "sort_order": 30,
            "created_at": "2019-02-08 14:24:00",
            "updated_at": "2019-02-08 14:24:01",
            "path": "http://charger.icargo.co/storage/app/uploads/public/5c5/dbb/306/5c5dbb3061c04761099984.png",
            "extension": "png"
        },
        "ciudad": {
            "id": 13,
            "nombre": " Los Cedrales",
            "localidad_id": 2,
            "localidad": {
                "id": 2,
                "nombre": " Alto Parana",
                "pais_id": 1,
                "pais": {
                    "id": 1,
                    "nombre": "Paraguay"
                }
            }
        }
    },
    "destino": {
        "id": 3,
        "nombre": "GICAL KM12",
        "nombre_corto": null,
        "documento": null,
        "tipo_entidad": "Centro Operativo",
        "direccion": "GICAL KM 12",
        "ciudad_id": 11,
        "latlon": {
            "latitud": "-25.4921592",
            "longitud": "-54.72833349999996"
        },
        "contacto": {
            "url": null,
            "contactos": [],
            "informacion_adicional": null
        },
        "tipo_documento_id": null,
        "persona_juridica_id": null,
        "user_id": null,
        "created_at": "2019-02-08 14:04:51",
        "updated_at": "2019-02-08 14:04:51",
        "deleted_at": null,
        "latitud": "-25.4921592",
        "longitud": "-54.72833349999996",
        "url": null,
        "contactos": [],
        "informacion_adicional": null,
        "activar_usuario": false,
        "logo": {
            "id": 29,
            "disk_name": "5c5dbb218af20195602245.png",
            "file_name": "Icono.png",
            "file_size": 3374,
            "content_type": "image/png",
            "title": null,
            "description": null,
            "field": "logo",
            "sort_order": 29,
            "created_at": "2019-02-08 14:23:45",
            "updated_at": "2019-02-08 14:23:51",
            "path": "http://charger.icargo.co/storage/app/uploads/public/5c5/dbb/218/5c5dbb218af20195602245.png",
            "extension": "png"
        },
        "ciudad": {
            "id": 11,
            "nombre": " Hernandarias",
            "localidad_id": 2,
            "localidad": {
                "id": 2,
                "nombre": " Alto Parana",
                "pais_id": 1,
                "pais": {
                    "id": 1,
                    "nombre": "Paraguay"
                }
            }
        }
    },
    "carga": {
        "id": 1,
        "nombre": "SOJA EN GRANOS",
        "nombre_corto": "SOJA",
        "descripcion": "",
        "tipo_carga_id": 1,
        "transportadora_id": null,
        "created_at": "2019-02-08 14:38:19",
        "updated_at": "2019-02-08 14:38:19",
        "deleted_at": null
    },
    "unidad_transportadora": {
        "id": 2,
        "nombre": "Toneladas",
        "abreviatura": "TON",
        "valor_kg": 1000,
        "transportadora_id": null,
        "created_at": null,
        "updated_at": null,
        "deleted_at": null
    },
    "unidad_transportista": {
        "id": 1,
        "nombre": "Kilogramos",
        "abreviatura": "KG",
        "valor_kg": 1,
        "transportadora_id": null,
        "created_at": null,
        "updated_at": null,
        "deleted_at": null
    },
    "unidad_merma_transportadora": {
        "id": 1,
        "nombre": "Kilogramos",
        "abreviatura": "KG",
        "valor_kg": 1,
        "transportadora_id": null,
        "created_at": null,
        "updated_at": null,
        "deleted_at": null
    },
    "unidad_merma_transportista": {
        "id": 1,
        "nombre": "Kilogramos",
        "abreviatura": "KG",
        "valor_kg": 1,
        "transportadora_id": null,
        "created_at": null,
        "updated_at": null,
        "deleted_at": null
    },
    "moneda_transportadora": {
        "id": 1,
        "nombre": "Guaranies",
        "simbolo": "PYG",
        "es_moderado": true,
        "created_at": null,
        "updated_at": null,
        "deleted_at": null
    },
    "moneda_transportista": {
        "id": 1,
        "nombre": "Guaranies",
        "simbolo": "PYG",
        "es_moderado": true,
        "created_at": null,
        "updated_at": null,
        "deleted_at": null
    },
    "subasta": null,
    "aviso_legal": {
        "id": 1,
        "titulo": "Orden de Carga",
        "leyenda": "Entre los objetivos principales de la plataforma se encuentra la presentación de reportes que permita un análisis rápido y ágil de la información, para la toma de decisiones estratégicas. \r\nSe ofrecerán reportes en tablas con acceso a los campos más importantes de las tablas de la base de datos, con opciones de filtro. Dichos reportes filtrados podrán ser exportados, luego, a formato Excel (.xls, xlsx)",
        "transportadora_id": 7,
        "created_at": "2019-02-08 14:35:31",
        "updated_at": "2019-02-08 14:35:43",
        "deleted_at": null
    },
    "descuentos": [],
    "complementos": []
}
 */