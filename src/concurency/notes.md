* A thread is the smallest unit of execution that can be scheduled byt the operating system.
* A process is a group of associated threads that run in the same shared environment
* Shared environment is shared memory and space also thread can communicate with each other
* A task is a single unit of work performed by a thread

#### Distinguishing thread types
* System thread: created by the jvm and runs in the background of the application
* User defined thread: created by the application developer to run a specific task
* daemon: will not prevent the application from exiting when the program finishes

###concurrency
* Concurrency: the property of executing multiple tasks and processes at the same time
* context switching: occurs when the allotted time for a specific thread is complete but the thread has not completed execution
* A context switch is the process of storing the current state of a thread and later restoring the state to continue execution
* Thread priority is numeric value associate with a task taken into consideration by the scheduler
* calling `run()` does not start a new thread
* polling: the process of intermittently checking data at a fixed interval

####Creating a task
* you can implement a runnable interface
* You can use a lambda to implement the runnable interface: `Runnable task = () -> { print hello world }`
* you can extend the Thread class
* you can use the ExecutorService API

####ExecutorService
* ExecutorService is an interface
* A thread executor creates a non-daemon task on the first task that is executed so failing to shutdown will result to application never terminating
* when you call `isShutDown()` all pending tasks will continue executing while any new task that is being submitted will return a `RejectExecutionException`
* until all tasks are terminated isShutDown will return true & isTerminated will return false

###### Submitting a tas using the executor service
* create an instance of the executorService
* prepare your runnable tasks
* inside the try block - instantiate the ExecutorService using the factory method of your choice
* submit your runnable tasks to the instance of the executor service using `execute()` or `submit()`
* remember to close your resources using the finally block
* with a single-thread executor results are guaranteed to be ordered sequentially
