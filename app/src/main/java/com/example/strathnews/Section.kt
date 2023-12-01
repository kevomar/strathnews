package com.example.strathnews

interface Section {
    val title: String
    val route: String
    val category: String
}

object TopNews: Section {
    override val title = "Top News"
    override val route = "top_News"
    override val category = "top_news"
}

object Sports: Section {
    override val title = "Sports"
    override val route = "sports"
    override val category = "sports"
}

object Entertainment: Section {
    override val title = "Entertainment"
    override val route = "entertainment"
    override val category = "entertainment"
}

object Clubs: Section {
    override val title = "Clubs"
    override val route = "clubs"
    override val category = "clubs"
}

object OpinionsAndBlogs: Section{
    override val title = "Opinions and Blogs"
    override val route = "opinions_and_blogs"
    override val category = "opinions_and_blogs"
}

val sections = listOf(TopNews, Sports, Entertainment, Clubs/*, OpinionsAndBlogs8*/)