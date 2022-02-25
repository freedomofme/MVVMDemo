# MVVMDemo--Cat Image Gallery

## Quick Start
You may modify the config of sdk.dir in local.properties

## Architecture
* MVVM (LiveData & View Model & Rep)
* Dagger (for DI)
* Arouter (page jump, suitable for multi-module)
* Componentization

## Function of each module

* base module provides standard functions, such as network requests, database read and write
* app module should be just a container (but for now contains some feature); 
* catdetail module shows the big image of cats.

### Compile independent
Modify the variable isModule in gradle.properties file.
isModule = true means each business module can run independently except app module.
isModule = false means only the app module can run.


### CATS API
[https://docs.thecatapi.com/](https://docs.thecatapi.com/)

#### get cats breed list
    @GET("v1/breeds")

### TODO
* add unit test using Junit and Mockito
* move out feature from app module to make it just a container
* use DiffUtil to speed up.
* paging
* set glide options
* CatsListRepository needs to be further abstracted now this file contains some template code.