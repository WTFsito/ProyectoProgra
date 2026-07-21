🎮 Tres en Raya en Java

Un clásico Tres en Raya (Tic Tac Toe)- version mejorada 

📌 Características

✅ Juego para 2 jugadores

✅ Tablero dinámico con matriz 4x4 con interfaz grafica

✅Uso de un lector de codigo de barras para cada turno.

✅ Uso de un tablero similar al del 3 en raya, con la diferencia que en cada lugar habra un codigo de barras con un valor constante - unico.

✅ Validación de casillas ocupadas

✅ Validación de filas, columnas y diagonales

✅ Sistema de empate

✅ Reinicio de partida desde menú

✅ Alternancia automática entre X y O

==================================================================
 ESTÁNDARES DE CODIFICACIÓN DEL PROYECTO
==================================================================
Este documento describe las convenciones que se deben seguir al
contribuir con código a este proyecto. El objetivo es mantener
consistencia y legibilidad para cualquier persona que colabore.

------------------------------------------------------------------
1. IDIOMA
------------------------------------------------------------------
- Todo el código debe escribirse en ESPAÑOL: nombres de variables,
  métodos, clases, comentarios y mensajes mostrados al usuario.
- Excepción: palabras reservadas del lenguaje Java y nombres de
  clases/librerías propias de Swing u otras APIs (JPanel, JLabel,
  ActionListener, etc.), que se mantienen en inglés porque son
  parte del lenguaje, no una elección de nomenclatura.

Ejemplo correcto:
    private int contadorTurno = 1;
    private void actualizarIndicadoresTurno() { ... }

Ejemplo incorrecto (no usar inglés para nombres propios):
    private int turnCounter = 1;

------------------------------------------------------------------
2. CASING (formato de nombres)
------------------------------------------------------------------
- Variables y métodos:      camelCase
      estadoActual, imgVacia, obtenerCoordenadasPorCodigo()

- Clases:                   PascalCase
      CasillaLabel, MainForm, TableroPanel

- Constantes (static final): UPPER_SNAKE_CASE
      public static final int VACIO = 0;
      public static final int X = 1;

- Parámetros de métodos: SIEMPRE en minúscula inicial, sin
  excepción (evitar casos como "NuevoPanel" en vez de
  "nuevoPanel").

------------------------------------------------------------------
3. PREFIJOS SEGÚN TIPO DE COMPONENTE
------------------------------------------------------------------
Usar prefijos cortos para identificar visualmente el tipo de
variable, especialmente en componentes de interfaz gráfica (GUI):

    lbl   -> JLabel                  lblTurnoNumero
    btn   -> Botón / JButton         btnJugar, btnSalir
    img   -> ImageIcon / Image       imgVacia, imgX, imgO
    ruta  -> URL o path de recurso   rutaFondo, rutaImagen
    caja  -> JTextField              cajaDeTexto1

------------------------------------------------------------------
4. ESTRUCTURA Y ORGANIZACIÓN
------------------------------------------------------------------
- Declarar los atributos de instancia al inicio de la clase, antes
  del constructor.
- Evitar strings o valores "mágicos" repetidos en varias clases
  (ej. rutas de imágenes o códigos hardcodeados). Si un valor se
  usa en más de un lugar, debe centralizarse en una clase de
  constantes o configuración (ej. Constantes.java).
- Preferir estructuras dinámicas (arreglos + bucles for) sobre
  variables numeradas manualmente (c1, c2, c3...) cuando se trata
  de colecciones repetitivas de objetos similares.
- Cada clase debe cumplir una sola responsabilidad clara (vista,
  lógica de juego, modelo de datos, etc.) en la medida de lo
  posible; evitar mezclar demasiada lógica de negocio dentro de
  clases de interfaz gráfica.

------------------------------------------------------------------
5. COMENTARIOS
------------------------------------------------------------------
- Usar comentarios breves en español para explicar el "por qué"
  de una decisión, no el "qué" (el código ya dice qué hace).
- Comentar bloques de lógica no evidente (ej. reglas de turno,
  condiciones de victoria), no cada línea.

------------------------------------------------------------------
6. BUENAS PRÁCTICAS GENERALES
------------------------------------------------------------------
- Validar siempre antes de asumir que un recurso existe (ej. una
  imagen cargada desde disco) y manejar el caso nulo con un
  mensaje claro, como ya se hace en cargarIcono().
- Usar JOptionPane u otro mecanismo consistente para mostrar
  advertencias y errores al usuario, evitando mezclarlo con
  System.out.println en producción.
- Mantener sangría de 4 espacios y llaves en la misma línea de la
  declaración (estilo usado en todo el proyecto actual).

==================================================================

==================================================================





