package com.example.apexgym

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "ApexTesting.db", null, 2) {

    override fun onCreate(db: SQLiteDatabase?) {
        // 1. TABLA USUARIOS (Quienes usan la app - Empleados)
        db?.execSQL("""
            CREATE TABLE Usuario (
                id_usuario INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT UNIQUE,
                password TEXT,
                rol TEXT
            )
        """)

        // 2. TABLA CLIENTES
        db?.execSQL("""
            CREATE TABLE Cliente (
                id_cliente INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT,
                apellido TEXT,
                telefono TEXT,
                estado TEXT
            )
        """)

        // Inserción del Usuario Administrador por defecto para que puedas entrar
        val admin = ContentValues().apply {
            put("username", "admin")
            put("password", "1234")
            put("rol", "Administrador")
        }
        db?.insert("Usuario", null, admin)
    }

    override fun onUpgrade(db: SQLiteDatabase?, old: Int, new: Int) {
        db?.execSQL("DROP TABLE IF EXISTS Usuario")
        db?.execSQL("DROP TABLE IF EXISTS Cliente")
        onCreate(db)
    }

    // ==========================================
    // LÓGICA DE INICIO DE SESIÓN Usuarios)
    // ==========================================
    fun validarLogin(user: String, pass: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM Usuario WHERE username=? AND password=?", arrayOf(user, pass))
        val success = cursor.count > 0
        cursor.close()
        return success
    }

    // ==========================================
    // LÓGICA DE Clientes
    // ==========================================
    fun registrarCliente(nombre: String, apellido: String, telefono: String): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("nombre", nombre)
            put("apellido", apellido)
            put("telefono", telefono)
            put("estado", "Activo")
        }
        return db.insert("Cliente", null, values)
    }

    // ==========================================
    // CONSULTA GENERAL DE CLIENTES
    // ==========================================
    fun getAllClientes(): android.database.Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM Cliente", null)
    }

    // ==========================================
    // CRUD DE USUARIOS (Altas, Bajas, Cambios)
    // ==========================================
    fun registrarUsuario(user: String, pass: String): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply { put("username", user); put("password", pass); put("rol", "Admin") }
        return db.insert("Usuario", null, values) != -1L
    }

    fun buscarUsuario(username: String): android.database.Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM Usuario WHERE username=?", arrayOf(username))
    }

    fun actualizarUsuario(id: Int, newUser: String, newPass: String): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply { put("username", newUser); put("password", newPass) }
        return db.update("Usuario", values, "id_usuario=?", arrayOf(id.toString())) > 0
    }

    fun eliminarUsuario(id: Int): Boolean {
        val db = this.writableDatabase
        return db.delete("Usuario", "id_usuario=?", arrayOf(id.toString())) > 0
    }
}