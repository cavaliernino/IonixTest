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

package com.bozzi.ionix.prueba1.data

import androidx.lifecycle.LiveData
import com.bozzi.ionix.prueba1.data.model.Result
import com.bozzi.ionix.prueba1.data.model.Result.Success
import com.bozzi.ionix.prueba1.data.dao.TasksDataSource
import com.bozzi.ionix.prueba1.data.model.Task
import com.bozzi.ionix.prueba1.util.wrapEspressoIdlingResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface TasksRepository {

    //fun observeTasks(): LiveData<kotlin.Result<List<Task>>>

    suspend fun getTasks(forceUpdate: Boolean = false): Result<Flow<List<Task>>>

    //suspend fun refreshTasks()

    //fun observeTask(taskId: String): LiveData<kotlin.Result<Task>>

    //suspend fun getTask(taskId: String, forceUpdate: Boolean = false): kotlin.Result<Task>

    //suspend fun refreshTask(taskId: String)

    //suspend fun saveTask(task: Task)

    //suspend fun completeTask(task: Task)

    //suspend fun completeTask(taskId: String)

    //suspend fun activateTask(task: Task)

    //suspend fun activateTask(taskId: String)

    //suspend fun clearCompletedTasks()

    //suspend fun deleteAllTasks()

    //suspend fun deleteTask(taskId: String)
}

class DefaultTasksRepository @Inject constructor(
    /*private val tasksRemoteDataSource: TasksDataSource,*/
    private val tasksLocalDataSource: TasksDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : TasksRepository {

    override suspend fun getTasks(forceUpdate: Boolean): Result<Flow<List<Task>>> {
        withContext(ioDispatcher) {
            // Set app as busy while this function executes.
            wrapEspressoIdlingResource {

                if (forceUpdate) {
                    try {
                        updateTasksFromRemoteDataSource()
                    } catch (ex: Exception) {
                        return@withContext Result.Error(ex)
                    }
                }
                return@withContext Success(tasksLocalDataSource.getTasks())
            }
        }
        return Result.Error(java.lang.Exception(""))
    }

    private suspend fun updateTasksFromRemoteDataSource() {
        /*val remoteTasks = tasksRemoteDataSource.getTasks()

        if (remoteTasks is Success) {
            // Real apps might want to do a proper sync, deleting, modifying or adding each task.
            tasksLocalDataSource.deleteAllTasks()
            remoteTasks.data.forEach { task ->
                tasksLocalDataSource.saveTask(task)
            }
        } else if (remoteTasks is kotlin.Result.Error) {
            throw remoteTasks.exception
        }*/
    }
}
