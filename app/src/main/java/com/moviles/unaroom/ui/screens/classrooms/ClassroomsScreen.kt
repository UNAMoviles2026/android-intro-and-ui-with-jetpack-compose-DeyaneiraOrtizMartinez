package com.moviles.unaroom.ui.screens.classrooms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviles.unaroom.data.Classroom

@Composable
fun ClassroomsScreen(
    modifier: Modifier = Modifier,
    successMessage: String? = null,
    onSuccessMessageShown: () -> Unit = {},
    onLogoutClick: () -> Unit = {}
) {
    // Mock list
    val classrooms = listOf(
        Classroom(name = "A-101", capacity = 30, location = "Building A"),
        Classroom(name = "B-204", capacity = 45, location = "Building B"),
        Classroom(name = "Lab-3", capacity = 20, location = "Tech Wing")
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Classrooms Screen",
            style = MaterialTheme.typography.headlineSmall
        )
        
        if (successMessage != null) {
            Text(text = successMessage, color = MaterialTheme.colorScheme.primary)
            // Ideally use a snackbar, but for verification this works
            LaunchedEffect(successMessage) {
                // Simulate showing message
                onSuccessMessageShown()
            }
        }

        Button(onClick = onLogoutClick) {
            Text("Logout")
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(classrooms) { classroom ->
                Card(modifier = Modifier.padding(4.dp)) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(text = classroom.name, style = MaterialTheme.typography.titleMedium)
                        Text(text = "Capacity: ${classroom.capacity}")
                        Text(text = classroom.location)
                    }
                }
            }
        }
    }
}
