# MVVMDemo--Cat Image Gallery

### Architecture
* MVVM (* LiveData & View Model)
* Dagger
* Arouter


base module provide base class and function; app should be a container(but for now contains some feature); 
catdetail module show the detail info of cats.

### CATS API
[https://docs.thecatapi.com/](https://docs.thecatapi.com/)

#### get cats breed list

#### get info of cats breed

### TODO
* move out feature from app module to make it as just a container
* use DiffUtil to speed up.
* paging
* set glide options
* CatsListRepository needs to be further abstracted, now this file contains some template code.









