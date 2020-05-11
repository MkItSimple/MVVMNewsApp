package com.example.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmnewsapp.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>> // LiveData #11 10:00

    @Delete
    suspend fun deleteArticle(article: Article)
}