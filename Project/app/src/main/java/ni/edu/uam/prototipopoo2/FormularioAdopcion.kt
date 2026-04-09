package ni.edu.uam.prototipopoo2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// =========================
// PALETA DE COLORES
// =========================
private val AzulOscuro = Color(0xFF0A2F51)
private val AzulProfundo = Color(0xFF0E4D64)
private val VerdeAzulado = Color(0xFF137177)
private val VerdeMedio = Color(0xFF188977)
private val VerdePrimario = Color(0xFF1D9A6C)
private val VerdeBoton = Color(0xFF39A96B)
private val VerdeClaro = Color(0xFF56B870)
private val VerdeSuave = Color(0xFF74C67A)
private val VerdePastel = Color(0xFF99D492)
private val VerdeFondo = Color(0xFFBFE1B0)
private val FondoGeneral = Color(0xFFDEEDCF)
private val Blanco = Color(0xFFFFFFFF)


private val BalooFamily = FontFamily(
    Font(R.font.baloo_regular)
)

private val RobotoFamily = FontFamily(
    Font(R.font.roboto_regular)
)

// =========================
// FORMULARIO
// =========================
@Composable
fun FormularioAdopcion(idMascota: Int) {

    var nombreCompleto by rememberSaveable { mutableStateOf("") }
    var correo by rememberSaveable { mutableStateOf("") }
    var telefono by rememberSaveable { mutableStateOf("") }
    var direccion by rememberSaveable { mutableStateOf("") }
    var tipoVivienda by rememberSaveable { mutableStateOf("") }
    var experienciaMascotas by rememberSaveable { mutableStateOf("") }
    var motivoAdopcion by rememberSaveable { mutableStateOf("") }
    var tieneOtrasMascotas by rememberSaveable { mutableStateOf(false) }
    var aceptaTerminos by rememberSaveable { mutableStateOf(false) }
    var intentoEnviar by rememberSaveable { mutableStateOf(false) }

    val correoValido = remember(correo) {
        correo.matches(Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
    }

    val telefonoValido = remember(telefono) {
        telefono.length >= 8
    }

    val formularioValido =
        nombreCompleto.isNotBlank() &&
                correoValido &&
                telefonoValido &&
                direccion.isNotBlank() &&
                tipoVivienda.isNotBlank() &&
                experienciaMascotas.isNotBlank() &&
                motivoAdopcion.isNotBlank() &&
                aceptaTerminos

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoGeneral)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            // HEADER SUPERIOR
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(AzulOscuro, AzulProfundo, VerdeAzulado)
                        )
                    )
                    .padding(horizontal = 24.dp, vertical = 32.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(92.dp)
                            .shadow(8.dp, CircleShape)
                            .background(VerdePastel, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "🐶🐱",
                            fontSize = 34.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Solicitud de Adopción",
                        style = TextStyle(
                            fontFamily = BalooFamily,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Blanco
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Completa el formulario para continuar con la evaluación de la mascota #$idMascota",
                        style = TextStyle(
                            fontFamily = RobotoFamily,
                            fontSize = 15.sp,
                            color = Blanco.copy(alpha = 0.92f)
                        )
                    )
                }
            }

            // TARJETA PRINCIPAL
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-24).dp)
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(containerColor = Blanco),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {

                    Text(
                        text = "Datos del solicitante",
                        style = TextStyle(
                            fontFamily = BalooFamily,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = AzulOscuro
                        )
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Los campos marcados son necesarios para revisar tu solicitud.",
                        style = TextStyle(
                            fontFamily = RobotoFamily,
                            fontSize = 14.sp,
                            color = AzulProfundo.copy(alpha = 0.80f)
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    SectionTitle("Información personal")

                    AdoptaTextField(
                        value = nombreCompleto,
                        onValueChange = { nombreCompleto = it },
                        label = "Nombre completo *",
                        placeholder = "Ej. María Fernanda López",
                        isError = intentoEnviar && nombreCompleto.isBlank(),
                        supportingText = if (intentoEnviar && nombreCompleto.isBlank()) {
                            "Ingresa tu nombre completo."
                        } else null
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    AdoptaTextField(
                        value = correo,
                        onValueChange = { correo = it },
                        label = "Correo electrónico *",
                        placeholder = "ejemplo@correo.com",
                        keyboardType = KeyboardType.Email,
                        isError = intentoEnviar && !correoValido,
                        supportingText = if (intentoEnviar && !correoValido) {
                            "Ingresa un correo válido."
                        } else null
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    AdoptaTextField(
                        value = telefono,
                        onValueChange = { telefono = it.filter { char -> char.isDigit() } },
                        label = "Teléfono *",
                        placeholder = "8888 8888",
                        keyboardType = KeyboardType.Phone,
                        isError = intentoEnviar && !telefonoValido,
                        supportingText = if (intentoEnviar && !telefonoValido) {
                            "Ingresa un número de teléfono válido."
                        } else null
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    AdoptaTextField(
                        value = direccion,
                        onValueChange = { direccion = it },
                        label = "Dirección *",
                        placeholder = "Colonia, casa, referencias...",
                        isError = intentoEnviar && direccion.isBlank(),
                        supportingText = if (intentoEnviar && direccion.isBlank()) {
                            "Ingresa tu dirección."
                        } else null,
                        singleLine = false,
                        minLines = 3
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    SectionTitle("Detalles para la adopción")

                    AdoptaTextField(
                        value = tipoVivienda,
                        onValueChange = { tipoVivienda = it },
                        label = "Tipo de vivienda *",
                        placeholder = "Casa, apartamento, finca...",
                        isError = intentoEnviar && tipoVivienda.isBlank(),
                        supportingText = if (intentoEnviar && tipoVivienda.isBlank()) {
                            "Describe tu tipo de vivienda."
                        } else null
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    AdoptaTextField(
                        value = experienciaMascotas,
                        onValueChange = { experienciaMascotas = it },
                        label = "Experiencia con mascotas *",
                        placeholder = "Cuéntanos si has cuidado mascotas antes",
                        isError = intentoEnviar && experienciaMascotas.isBlank(),
                        supportingText = if (intentoEnviar && experienciaMascotas.isBlank()) {
                            "Este campo es importante para la evaluación."
                        } else null,
                        singleLine = false,
                        minLines = 3
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    AdoptaTextField(
                        value = motivoAdopcion,
                        onValueChange = { motivoAdopcion = it },
                        label = "¿Por qué deseas adoptar? *",
                        placeholder = "Escribe tu motivo principal",
                        isError = intentoEnviar && motivoAdopcion.isBlank(),
                        supportingText = if (intentoEnviar && motivoAdopcion.isBlank()) {
                            "Explícanos brevemente tu motivación."
                        } else null,
                        singleLine = false,
                        minLines = 4
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Top
                    ) {
                        Checkbox(
                            checked = tieneOtrasMascotas,
                            onCheckedChange = { tieneOtrasMascotas = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = VerdeBoton,
                                uncheckedColor = VerdeAzulado,
                                checkmarkColor = Blanco
                            )
                        )

                        Text(
                            text = "Tengo otras mascotas en casa",
                            modifier = Modifier.padding(top = 12.dp),
                            style = TextStyle(
                                fontFamily = RobotoFamily,
                                fontSize = 15.sp,
                                color = AzulOscuro
                            )
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Top
                    ) {
                        Checkbox(
                            checked = aceptaTerminos,
                            onCheckedChange = { aceptaTerminos = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = VerdeBoton,
                                uncheckedColor = VerdeAzulado,
                                checkmarkColor = Blanco
                            )
                        )

                        Column(
                            modifier = Modifier.padding(top = 10.dp)
                        ) {
                            Text(
                                text = "Acepto los términos y condiciones *",
                                style = TextStyle(
                                    fontFamily = RobotoFamily,
                                    fontSize = 15.sp,
                                    color = AzulOscuro
                                )
                            )

                            if (intentoEnviar && !aceptaTerminos) {
                                Text(
                                    text = "Debes aceptar los términos para continuar.",
                                    style = TextStyle(
                                        fontFamily = RobotoFamily,
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colorScheme.error
                                    )
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    if (intentoEnviar && !formularioValido) {
                        Text(
                            text = "Revisa los campos obligatorios antes de enviar la solicitud.",
                            style = TextStyle(
                                fontFamily = RobotoFamily,
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.error
                            )
                        )

                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    Button(
                        onClick = {
                            intentoEnviar = true

                            if (formularioValido) {
                                // TODO: Redireccionar a Resultado() después de aceptar
                                // Ejemplo si luego usas Navigation:
                                // navController.navigate("resultado/$idMascota")
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(18.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = VerdeBoton,
                            contentColor = Blanco
                        )
                    ) {
                        Text(
                            text = "Enviar Solicitud",
                            style = TextStyle(
                                fontFamily = BalooFamily,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Tu información será utilizada únicamente para evaluar la adopción responsable.",
                        style = TextStyle(
                            fontFamily = RobotoFamily,
                            fontSize = 12.sp,
                            color = AzulProfundo.copy(alpha = 0.70f)
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

// =========================
// COMPONENTES AUXILIARES
// =========================
@Composable
private fun SectionTitle(text: String) {
    Column {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = BalooFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = VerdeMedio
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        HorizontalDivider(
            thickness = 1.dp,
            color = VerdePastel.copy(alpha = 0.8f)
        )

        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
private fun AdoptaTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    isError: Boolean = false,
    supportingText: String? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    singleLine: Boolean = true,
    minLines: Int = 1
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        singleLine = singleLine,
        minLines = minLines,
        maxLines = if (singleLine) 1 else 6,
        shape = RoundedCornerShape(18.dp),
        textStyle = TextStyle(
            fontFamily = RobotoFamily,
            fontSize = 15.sp,
            color = AzulOscuro
        ),
        label = {
            Text(
                text = label,
                style = TextStyle(
                    fontFamily = RobotoFamily,
                    color = AzulProfundo
                )
            )
        },
        placeholder = {
            Text(
                text = placeholder,
                style = TextStyle(
                    fontFamily = RobotoFamily,
                    color = AzulProfundo.copy(alpha = 0.45f)
                )
            )
        },
        isError = isError,
        supportingText = {
            if (!supportingText.isNullOrBlank()) {
                Text(
                    text = supportingText,
                    style = TextStyle(
                        fontFamily = RobotoFamily,
                        fontSize = 12.sp
                    )
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = VerdePrimario,
            unfocusedBorderColor = VerdePastel,
            focusedLabelColor = VerdePrimario,
            cursorColor = VerdePrimario,
            focusedContainerColor = Blanco,
            unfocusedContainerColor = Blanco
        )
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewFormularioAdopcion() {
    FormularioAdopcion(idMascota = 1)
}