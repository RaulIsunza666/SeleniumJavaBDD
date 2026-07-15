Feature: Login en SauceDemo

  @login
  Scenario: Inicio de sesión exitoso

    Given el usuario abre la aplicación
    When ingresa credenciales válidas
    Then visualiza el inventario

  @invalidUser
  Scenario: Inicio de sesión con usuario incorrecto
    Given el usuario abre la aplicación
    When ingresa nombre inválido y contraseña correcta
    Then visualiza mensaje de error

  @invalidPassword
  Scenario: Inicio de sesión con contraseña incorrecta
    Given el usuario abre la aplicación
    When ingresa nombre válido y contraseña incorrecta
    Then visualiza mensaje de error
