package com.example.strathnews.data

import android.util.Log
import com.example.strathnews.R
import java.util.Date

object NewsObject {
    val newsObj1 = News(
        image = R.drawable.image,
        title = "This is the title",
        description = "The description",
        author = "Kelvin Maritim",
        date = Date(2012,12,12),
        content = "The content"
    )
    val newsList: List<News> = listOf(
        News(
            image = R.drawable.strath_sports,
            title = "Sprint to Victory",
            description = "Strathmore Smashes Records at Annual Sports Day",
            author = "Kelvin Maritim",
            date = Date(2012,12,12),
            content = "Witness the adrenaline-pumping highlights of Strathmore University's Sports Day, where students showcased athleticism, sportsmanship, and a collective spirit of competition."
        ),
        News(
            image = R.drawable.strath_medicine,
            title = "Exciting Discovery in Medicine Revolutionizes Treatment",
            description = "A breakthrough study reveals new possibilities in disease management.",
            author = "Dr. Scientist",
            date = Date(),
            content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tempor lacinia ullamcorper."
        ),
        News(
            image = R.drawable.strath_transport,
            title = "Groundbreaking Technology Changes the Future of Transportation",
            description = "Innovative technology promises to reshape the way we travel.",
            author = "Tech Guru",
            date = Date(),
            content = "Sed eget dolor vitae nisl faucibus aliquet. Ut efficitur arcu odio, at convallis libero gravida in."
        ),
        News(
            image = R.drawable.strath_env,
            title = "New Environmental Initiatives Transform Sustainable Living",
            description = "Initiatives across the globe bring positive changes to the environment.",
            author = "Eco Warrior",
            date = Date(),
            content = "Vestibulum eu odio at purus rhoncus convallis nec at nunc. Cras fermentum orci sed sapien posuere."
        ),
        News(
            image = R.drawable.strath_ai,
            title = "Artificial Intelligence Breakthroughs Transform Industries",
            description = "AI innovations redefine business strategies and daily life.",
            author = "AI Expert",
            date = Date(),
            content = "Fusce eget bibendum urna, sit amet molestie magna. Phasellus maximus efficitur ligula, eu convallis ipsum."
        ),
        News(
            image = R.drawable.strath_enter,
            title = "Entertainment Industry Sees a Revolution in Streaming Services",
            description = "Streaming platforms redefine the entertainment landscape.",
            author = "Entertainment Analyst",
            date = Date(),
            content = "Praesent ut libero nec ligula consequat tincidunt vel at metus. Suspendisse potenti."
        ),
        News(
            image = R.drawable.strath_renewable,
            title = "Global Efforts Towards Renewable Energy Reach New Heights",
            description = "Renewable energy initiatives gain momentum worldwide.",
            author = "Renewable Advocate",
            date = Date(),
            content = "Donec id bibendum dolor, at mattis metus. Nullam id orci ut odio aliquet commodo."
        ),
        News(
            image = R.drawable.strath_robotics,
            title = "Advancements in Robotics Transform Manufacturing Processes",
            description = "Robotic technologies revolutionize production and efficiency.",
            author = "Robotics Engineer",
            date = Date(),
            content = "Vivamus sed sapien vel elit euismod bibendum. Nulla facilisi."
        ),
        News(
            image = R.drawable.strath_elearning,
            title = "Education Witnesses Innovations in E-Learning Platforms",
            description = "E-learning platforms reshape traditional education methods.",
            author = "Education Technologist",
            date = Date(),
            content = "Proin ultricies consectetur massa at feugiat. Nullam euismod eros in dui facilisis, vel tempus justo consequat."
        ),
        News(
            image = R.drawable.strath_space,
            title = "Space Exploration Enters a New Era of Discoveries",
            description = "Explorations in space uncover remarkable discoveries.",
            author = "Space Explorer",
            date = Date(),
            content = "Aliquam erat volutpat. Aenean id enim sit amet est dignissim efficitur."
        ),
        News(
            image = R.drawable.strath_fashion,
            title = "Fashion Industry Introduces Sustainable and Ethical Practices",
            description = "Fashion industry embraces sustainability and ethical practices.",
            author = "Fashion Critic",
            date = Date(),
            content = "Etiam vulputate gravida neque, a varius velit tempor vitae. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae."
        )
    )

    fun getNews(news: String?): News {
        val cleanNewsTitle = news?.removeSurrounding("{", "}")
        Log.d("NewsObject", "Requested news title: $cleanNewsTitle")

        val foundNews = newsList.firstOrNull { it.title == cleanNewsTitle }
        if (foundNews != null) {
            Log.d("NewsObject", "Found news: $foundNews")
            return foundNews
        } else {
            Log.e("NewsObject", "News not found for title: $cleanNewsTitle")
            // Handle the case where the news isn't found (return a default or handle null)
            // Example: return a default news item or throw an exception
            throw NoSuchElementException("News not found for title: $cleanNewsTitle")
        }
    }
}

