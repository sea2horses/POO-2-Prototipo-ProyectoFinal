package ni.edu.uam.prototipopoo2

import java.util.Optional

data class Mascota(
    val id: Int,
    val nombre: String,
    val especie: String,
    val raza: String,
    val edad: Int,
    val sexo: String,
    val descripcion: String,
    val disponible: Boolean,
)

val mascotas = listOf(
    Mascota(1, "Luna", "Perro", "Golden Retriever", 2, "Hembra", "Muy amigable y juguetona", true),
    Mascota(2, "Max", "Perro", "Pastor Alemán", 3, "Macho", "Protector y leal", true),
    Mascota(3, "Milo", "Gato", "Criollo", 1, "Macho", "Curioso y travieso", true),
    Mascota(4, "Nala", "Gato", "Siames", 2, "Hembra", "Elegante y tranquila", true),
    Mascota(5, "Rocky", "Perro", "Bulldog", 4, "Macho", "Perezoso pero cariñoso", false),
    Mascota(6, "Coco", "Ave", "Loro", 5, "Macho", "Habla y canta mucho", true),
    Mascota(7, "Bella", "Perro", "Poodle", 2, "Hembra", "Muy activa y juguetona", true),
    Mascota(8, "Simba", "Gato", "Persa", 3, "Macho", "Tranquilo y dormilón", false),
    Mascota(9, "Toby", "Perro", "Beagle", 1, "Macho", "Explorador y curioso", true),
    Mascota(10, "Kiwi", "Ave", "Periquito", 1, "Hembra", "Pequeña y energética", true),
    Mascota(11, "Thor", "Perro", "Rottweiler", 4, "Macho", "Fuerte y protector", false),
    Mascota(12, "Lola", "Gato", "Criollo", 2, "Hembra", "Cariñosa y juguetona", true),
    Mascota(13, "Bruno", "Perro", "Doberman", 3, "Macho", "Muy inteligente", true),
    Mascota(14, "Mia", "Gato", "Bengala", 1, "Hembra", "Muy activa y curiosa", true),
    Mascota(15, "Zeus", "Perro", "Husky", 2, "Macho", "Enérgico y le encanta correr", true)
)

fun getMascotaByID(id: Int): Mascota? {
    for (mascota in mascotas) {
        if (mascota.id == id) {
            return mascota;
        }
    }
    return null;
}