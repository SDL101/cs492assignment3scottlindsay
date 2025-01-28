//  Scott Lindsay
//  OSU
//  CS492

package com.example.osu492assignment3scottlindsay

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
import com.example.osu492assignment3scottlindsay.data.Datasource
import com.example.osu492assignment3scottlindsay.model.Course
import com.example.osu492assignment3scottlindsay.ui.theme.Osu492Assignment3ScottLindsayTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Osu492Assignment3ScottLindsayTheme {
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
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
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
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

// Step 3: Preview Function
@Preview
@Composable
fun CourseListPreview() {
    Osu492Assignment3ScottLindsayTheme {
        CourseList(courses = Datasource().loadCourses())
    }
}
