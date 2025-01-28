package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Course
import com.example.affirmations.ui.theme.AffirmationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseList(courses = Datasource().loadCourses())
                }
            }
        }
    }
}

// Step 1: Create the Scrollable List of Courses
@Composable
fun CourseList(courses: List<Course>) {
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(courses) { course ->
            CourseCard(course)
        }
    }
}

// Step 2: Create Each Course Card
@Composable
fun CourseCard(course: Course) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // First Line: Department and Number (Bold)
            Text(
                text = "${course.department} ${course.number}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            // Second Line: Title
            Text(
                text = stringResource(id = course.titleResId),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            // Third Line: Capacity
            Text(
                text = "Capacity: ${course.capacity}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

// Step 3: Preview Function
@Composable
fun CourseListPreview() {
    AffirmationsTheme {
        CourseList(courses = Datasource().loadCourses())
    }
}
