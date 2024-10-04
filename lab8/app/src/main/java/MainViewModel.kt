package com.example.lab8

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    // Estado de la UI para la lista de categorías
    private val _categoryState = mutableStateOf(RecipeState())
    val categoryState: State<RecipeState> = _categoryState

    // Inicializa la obtención de categorías cuando el ViewModel se crea
    init {
        fetchCategories()
    }

    // Función para obtener las categorías usando el ApiService
    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                // Llamada a la API para obtener las categorías
                val response = recipeService.getCategories()

                // Actualiza el estado con la respuesta recibida
                _categoryState.value = _categoryState.value.copy(
                    categories = response.categories,
                    loading = false
                )
            } catch (e: Exception) {
                // Maneja errores actualizando el estado con un mensaje de error
                _categoryState.value = _categoryState.value.copy(
                    loading = false,
                    error = "Error fetching categories: ${e.message}"
                )
            }
        }
    }
}

// Clase para manejar el estado de la UI
data class RecipeState(
    val loading: Boolean = true,
    val categories: List<Category> = emptyList(),
    val error: String? = null
)
