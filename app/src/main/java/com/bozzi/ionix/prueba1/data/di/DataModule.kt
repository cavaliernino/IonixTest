/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bozzi.ionix.prueba1.data.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import com.bozzi.ionix.prueba1.data.TaskRepository
import com.bozzi.ionix.prueba1.data.DefaultTaskRepository
import com.bozzi.ionix.prueba1.data.dao.AppDatabase
import com.bozzi.ionix.prueba1.data.dao.TasksDataSource
import com.bozzi.ionix.prueba1.data.dao.TasksLocalDataSource
import com.bozzi.ionix.prueba1.data.model.Task
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import java.sql.Date
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {


    @Singleton
    @Binds
    fun bindsTaskRepository(
        taskRepository: DefaultTaskRepository
    ): TaskRepository

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RemoteTasksDataSource

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalTasksDataSource
/*
    @Singleton
    @RemoteTasksDataSource
    @Provides
    fun provideTasksRemoteDataSource(): TasksDataSource {
        return TasksRemoteDataSource
    }
*/
    @Singleton
    @LocalTasksDataSource
    @Provides
    fun provideTasksLocalDataSource(
        database: AppDatabase,
        ioDispatcher: CoroutineDispatcher
    ): TasksDataSource {
        return TasksLocalDataSource(
            database.taskDao(), ioDispatcher
        )
    }

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "IonixTasks.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO
}

class FakeTaskRepository @Inject constructor() : TaskRepository {
    override val tasks: Flow<List<Task>> = flowOf(fakeTasks)

    override suspend fun add(task: Task) {
        throw NotImplementedError()
    }
}
val t1 = Task(0, "One", "Task 1", false, System.currentTimeMillis(), null)
val t2 = Task(1, "Two", "Task 2", false, System.currentTimeMillis(), null)
val t3 = Task(2, "Three", "Task 3", false, System.currentTimeMillis(), null)
val fakeTasks = listOf(t1, t2, t3)
