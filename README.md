## SPORTCITY APP

Aplicación móvil de reservas deportivas que permite iniciar sesión con Firebase, consultar pistas (tenis,fútbol 7,pádel, basketball),
ver el detalle de cada pista y crear reservas que se guardan en una base de datos local (Room)


## carasteristicas principales
**Login en Firebase Auth**
- Inicio de sesión en correo y contraseña
- validación campos

**Home** 
- Deportes disponibles:
  - Fútbol 7
  - Tenis
  - Pádel
  - Basket

**Listado pistas por deporte**

- Lista de pistas obtenidas desde Room
- Cada pista muestra nombre, precio
- Navega a detalle

**Detalle de pista**

- Muestra el nombre, descripción y precio
- Selector muy sencillo de dia y hora
- Botón Reservar ahora que lleva al formulario

**Formulario Reserva**

- Campos de nombre, teléfono y comentario
- Valodaciones
- Al confirmar:
  - Se  guarda en Room
  - Se navega a pantalla de confirmación

**Confirmación reserva**

-Mensaje visual con datos de la pista reservada

**Mis Reservas**

- Listado de reservas guardadas en Room con tarjetas con información de la reserva (icono, nombre, fecha, hora)
- Botón de borrar reserva

**Arquitectura**

- **MVVM**
  - Capas
    - ui
      - Components (componentes reutilizables: BarraNav, PistaCard, resrvaItemCard )
      - navigation (NavHost y ScreenNavigation(clase sellada para las rutas))
      - screens (login, home, pistasDeporte, detalle, formulario, confirmación, mis reservas)
      - viewModel (viewmodel para reservas, login y pistas)
      
    - model (model para pistas, reserva y login)
    
    - data
      - local -> Daos, entidades Room y repositorios Room
      - auth (para gestionar la autenticación con Firebase)

    
**Se ha usado**
- Lenguaje: Kotlin
- UI: Jetpack Compose
- Autenticación con Firebase (email y contraseña)
- Room


**Mejoras futuras (Necesarias)**

- Pantalla de registro de usuario nuevo
- Reestablecimiento de contraseña por olvido
- Selección real de fecha no solo 3 dias
- Pantalla de perfil de usuario
- Pantalla de ayuda
- Backend remoto real (API REST) con servidor