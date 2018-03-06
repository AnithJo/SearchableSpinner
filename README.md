
Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

 	dependencies {
	        compile 'com.github.AnithJo.android_searchable_spinner:app:1.0'
	}


How to Use :


        SearchableSpinnerDialog searchableSpinnerDialog = new SearchableSpinnerDialog(this, listString, "Select State", "close");
To Show Dialog :
	searchableSpinnerDialog.showSearchableSpinnerDialog();

To get value on select:
        searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
            @Override
            public void onClick(ArrayList<String> item, int position) {

                Toast.makeText(MainActivity.this, "You've selected "+ item.get(position), Toast.LENGTH_LONG).show();
            }
        });
	
	
	
