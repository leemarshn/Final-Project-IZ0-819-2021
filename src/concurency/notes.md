* A thread is the smallest unit of execution that can be scheduled byt the operating system.
* A process is a group of associated threads that run in the same shared environment
* Shared environment is shared memory and space also thread can communicate with each other
* A task is a single unit of work performed by a thread

#### Distinguishing thread types
* System thread: created by the jvm and runs in the background of the application
* User defined thread: created by the application developer to run a specific task
* daemon: will not prevent the application from exiting when the program finishes

### concurrency
* Concurrency: the property of executing multiple tasks and processes at the same time
* context switching: occurs when the allotted time for a specific thread is complete but the thread has not completed execution
* A context switch is the process of storing the current state of a thread and later restoring the state to continue execution
* Thread priority is numeric value associate with a task taken into consideration by the scheduler
* calling `run()` does not start a new thread
* polling: the process of intermittently checking data at a fixed interval

#### Creating a task
* you can implement a runnable interface
* You can use a lambda to implement the runnable interface: `Runnable task = () -> { print hello world }`
* you can extend the Thread class
* you can use the ExecutorService API

#### ExecutorService
* ExecutorService is an interface
* A thread executor creates a non-daemon task on the first task that is executed so failing to shutdown will result to application never terminating
* when you call `isShutDown()` all pending tasks will continue executing while any new task that is being submitted will return a `RejectExecutionException`
* until all tasks are terminated isShutDown will return true & isTerminated will return false

###### Submitting a task using the executor service
* create an instance of the executorService
* prepare your runnable tasks
* inside the try block - instantiate the ExecutorService using the factory method of your choice
* submit your runnable tasks to the instance of the executor service using `execute()` or `submit()`
* remember to close your resources using the finally block
* with a single-thread executor results are guaranteed to be ordered sequentially

###### waiting for results

* using the `submit()` method to submit tasks you can determine the state of the task
* submit returns a future object which has the following methods
* `boolean isDone()` -> returns true if the task is complete threw an exception or cancelled
* `boolean isCancelled()` -> true if task was cancelled before it completed normally
*` boolean cancel(boolean var)` -> attempts to cancel a task and returns true if canceled
* `v get()` -> returns the results of the tasks and waits endlessly if not yet available
* `v get(long timeout, TimeUnit unit)` -> waits for a specified time if not yet available a TimeOutException is thrown
* `Future<V>` is a generic interface, the type `v` is determined by the return type of the` Runnable` since the return type of Runnable is void get will always return null


###### using callable
* callable is a functional interface has the method call `v call() throws exception`
* the `submit(callable task)` can take both a callable instance, or a runnable instance
* remember the future instance returns a generic interface in callable v is determined by the return type of the callable
* the call() method of the callable does not take any parameters but can return a value, the value returned can be accessed using the get method of the future instance

###### scheduling tasks
* schedule(Callable<V> callable, long delay, TimeUnit unit)
* schedule(Runnable command, long delay, TimeUnit unit)
* `scheduleAtFixedRate(runnable command,long initialDelay, long Delay, TimeUnit unit)` -> submits new tasks after the initial delay regardless of the termination of the previous task
* `scheduledWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)` -> creates a new task only if the previous task has completed
* There is a `ScheduledFuture<v>` which has a `getDelay()`

##### Thread Safety
* Atomic is the property of an operation to be carried out as a single unit of execution without any interference by other threads
###### Atomic classes
* AtomicBoolean
* AtomicInteger
* AtomicLong

* using atomic classes ensures that data is consistent between workers and no values are lost due to concurrent modifications
* Atomic classes have the following methods
* get()
* set()
* incrementAndGet() -> ++value
* decrementAndGet() -> --value
* getAndIncrement() -> value++
* getAndDecrement()
* getAndSet()

