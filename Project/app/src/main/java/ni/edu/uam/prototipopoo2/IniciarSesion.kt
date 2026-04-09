package ni.edu.uam.prototipopoo2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ni.edu.uam.prototipopoo2.ui.theme.DeepBlue
import ni.edu.uam.prototipopoo2.ui.theme.PrototipoPOO2Theme
import ni.edu.uam.prototipopoo2.ui.theme.SoftGreen

@Composable
fun IniciarSesion(onLoginSuccess: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var selectedTab by remember { mutableStateOf(0) } // 0 for Login, 1 for Register

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState)
    ) {
        // Header with Deep Blue Background (Transmite confianza y seguridad)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(DeepBlue)
                .padding(top = 60.dp, bottom = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // Logo/Isotype: Ilustración sencilla de mascota
                Surface(
                    modifier = Modifier.size(90.dp),
                    shape = RoundedCornerShape(24.dp),
                    color = Color.White.copy(alpha = 0.15f)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text("🐶", fontSize = 48.sp) // Representación simple
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "PetAdoption",
                    style = MaterialTheme.typography.displayLarge.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    ),
                    fontSize = 30.sp
                )
            }
        }

        // Navigation Tabs (Visibilidad del estado del sistema)
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TabItem(
                text = "Iniciar sesión",
                isSelected = selectedTab == 0,
                modifier = Modifier.weight(1f),
                onClick = { selectedTab = 0 }
            )
            TabItem(
                text = "Registrarse",
                isSelected = selectedTab == 1,
                modifier = Modifier.weight(1f),
                onClick = { selectedTab = 1 }
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            // Central friendly illustration (Punto emocional de conexión)
            Box(
                modifier = Modifier
                    .size(140.dp)
                    .background(MaterialTheme.colorScheme.tertiary.copy(alpha = 0.2f), RoundedCornerShape(70.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("🐈🐕", fontSize = 60.sp)
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Form Fields: Cajas amplias y redondeadas
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo electrónico", style = MaterialTheme.typography.bodyLarge) },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null, tint = DeepBlue) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = DeepBlue,
                    unfocusedBorderColor = Color.LightGray,
                    focusedLabelColor = DeepBlue
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña", style = MaterialTheme.typography.bodyLarge) },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null, tint = DeepBlue) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = DeepBlue,
                    unfocusedBorderColor = Color.LightGray,
                    focusedLabelColor = DeepBlue
                ),
                singleLine = true
            )

            // Forgot Password Link
            TextButton(
                onClick = { /* TODO */ },
                modifier = Modifier.align(Alignment.End),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    "¿Olvidaste tu contraseña?",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Primary Button: Iniciar Sesión (Color destacado y fácil de presionar)
            Button(
                onClick = onLoginSuccess,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = SoftGreen)
            ) {
                Text(
                    if (selectedTab == 0) "Iniciar sesión" else "Crear cuenta",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Secondary Button: Alternativa clara sin robar protagonismo
            OutlinedButton(
                onClick = { selectedTab = if (selectedTab == 0) 1 else 0 },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(20.dp),
                border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp)
            ) {
                Text(
                    if (selectedTab == 0) "Registrarse" else "Ya tengo cuenta",
                    style = MaterialTheme.typography.titleMedium.copy(color = DeepBlue)
                )
            }

            // Social Logins
            Text(
                "O accede con",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                modifier = Modifier.padding(top = 24.dp, bottom = 16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SocialButton(text = "Google", onClick = {})
                Spacer(modifier = Modifier.width(24.dp))
                SocialButton(text = "Facebook", onClick = {})
            }
            
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun TabItem(text: String, isSelected: Boolean, modifier: Modifier, onClick: () -> Unit) {
    Column(
        modifier = modifier
            .background(if (isSelected) Color.Transparent else Color.LightGray.copy(alpha = 0.05f))
            .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextButton(onClick = onClick) {
            Text(
                text = text,
                color = if (isSelected) DeepBlue else Color.Gray,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                fontSize = 16.sp,
                style = MaterialTheme.typography.titleLarge
            )
        }
        if (isSelected) {
            Box(
                modifier = Modifier
                    .height(4.dp)
                    .width(40.dp)
                    .background(DeepBlue, RoundedCornerShape(2.dp))
            )
        } else {
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun SocialButton(text: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.height(48.dp),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        Text(text, fontSize = 14.sp, color = DeepBlue, fontWeight = FontWeight.Medium)
    }
}
