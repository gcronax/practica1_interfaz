
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext



val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val verdes = Color(0xFFABDE96)

val azulesB = Color(0xFF3B9C8F)

val negro = Color(0xFF282B26)
val naranja = Color(0xFFE3711C)
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC),       // Púrpura claro
    secondary = Color(0xFF03DAC6),     // Verde-azulado
    tertiary = Color(0xFFCF6679),      // Rojo suave
    background = Color(0xFF2D2B2B),    // Fondo casi negro
    surface = Color(0xFF1E1E1E),       // Superficie gris oscuro
    onPrimary = Color(0xFF000000),     // Texto sobre primary
    onSecondary = Color(0xFF000000),
    onTertiary = Color(0xFF000000),
    onBackground = Color(0xFFFFFFFF),  // Texto claro
    onSurface = Color(0xFFFFFFFF)
)


private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),       // Púrpura oscuro
    secondary = Color(0xFF03DAC6),     // Verde-azulado
    tertiary = Color(0xFFB00020),      // Rojo fuerte
    background = Color(0xFFFFFFFF),    // Fondo blanco
    surface = Color(0xFFF2F2F2),       // Superficie gris claro
    onPrimary = Color(0xFFFFFFFF),     // Texto sobre primary
    onSecondary = Color(0xFF000000),
    onTertiary = Color(0xFFFFFFFF),
    onBackground = Color(0xFF000000),  // Texto oscuro
    onSurface = Color(0xFF000000)
)


@Composable
fun Practica1_interfazTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}