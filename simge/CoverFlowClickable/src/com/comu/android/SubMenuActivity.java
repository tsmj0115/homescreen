package com.comu.android;

import java.util.List;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;
import android.widget.TableRow.LayoutParams;

public class SubMenuActivity extends Activity implements OnItemClickListener {
	int temp=0;
	private Integer[] wallPapers;
	
	public static int currentPosition = 5;
	VeriTabani imagepath = new VeriTabani(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Called when the activity is first created
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sub_menu);
				
		final LinearLayout subLayout = (LinearLayout) findViewById(R.id.sub_layout);
		subLayout.setBackgroundResource(R.drawable.wallpaper_blue);
		
		final CoverFlow coverFlow = (CoverFlow) findViewById(this.getResources().getIdentifier(
	               "coverflow", "id", "com.comu.android"));
			setupCoverFlow(coverFlow);
					
		final Integer[] socialNetwork = getSocial();
		final String[] SocialIcons={"Facebook","Twitter","GTalk"};
		
		final Integer[] eggSocialNetwork = getEggSocial();
		final String[] eggSocialIcons={"Facebook","Twitter","GTalk"};
		
	    final Integer[] folder = getGallery();
	    final String[] FolderIcons={"Müzik","Resim","Video"};
	    
	    final Integer[] eggfolder = getEggGallery();
	    final String[] eggFolderIcons={"Müzik","Resim","Video"};
	    
	    final TableLayout table = (TableLayout) findViewById(R.id.tablelayout);
		table.setStretchAllColumns(true);
				
		  TableRow tr1 = new TableRow(this);
		  tr1.setLayoutParams(new LayoutParams(
                  LayoutParams.FILL_PARENT,
                  120));
		  tr1.setGravity(Gravity.CENTER);
		  TableRow tr2 = new TableRow(this);
		  tr2.setLayoutParams(new LayoutParams(
                  LayoutParams.FILL_PARENT,
                  40));
		  tr2.setGravity(Gravity.CENTER);
		  TableRow tr3 = new TableRow(this);
		  tr3.setLayoutParams(new LayoutParams(
                  LayoutParams.FILL_PARENT,
                  120));
		  tr3.setGravity(Gravity.CENTER);
		  TableRow tr4 = new TableRow(this);
		  tr4.setLayoutParams(new LayoutParams(
                  LayoutParams.FILL_PARENT,
                  40));
		  tr4.setGravity(Gravity.CENTER);
		  final ImageView img1 = new ImageView(this);
		  img1.setLayoutParams(new LayoutParams(
                  80,
                  80));
		  img1.setFocusable(true);
		  final ImageView img2 = new ImageView(this);
		  img2.setLayoutParams(new LayoutParams(
                  80,
                  80));
		  img2.setFocusable(true);
		  final ImageView img3 = new ImageView(this);
		  img3.setLayoutParams(new LayoutParams(
                  80,
                  80));
		  img3.setFocusable(true);
		  TextView it1 = new TextView(this);
		  it1.setLayoutParams(new LayoutParams(
                  80,
                  40));
		  it1.setTextSize(TypedValue.DENSITY_DEFAULT, 25);
		  it1.setGravity(Gravity.CENTER);
		  TextView it2 = new TextView(this);
		  it2.setLayoutParams(new LayoutParams(
                  80,
                  40));
		  it2.setTextSize(TypedValue.DENSITY_DEFAULT, 25);
		  it2.setGravity(Gravity.CENTER);
		  TextView it3 = new TextView(this);
		  it3.setLayoutParams(new LayoutParams(
                  80,
                  40));
		  it3.setTextSize(TypedValue.DENSITY_DEFAULT, 25);
		  it3.setGravity(Gravity.CENTER);
		  
	  
			if (currentPosition == 1) {
				Integer[] checkArray = SubMenu();
				if (checkArray[0] == 4) {
				Log.v("DEBUG", "checkArray:" + checkArray[0]);
				Log.v("DEBUG", "checkArray:" + socialNetwork[0]);
				it1.setText(SocialIcons[0]);
				it2.setText(SocialIcons[1]);
				it3.setText(SocialIcons[2]);
				img1.setImageResource(socialNetwork[0]);
				img1.setTag("facebook");
				img2.setImageResource(socialNetwork[1]);
				img2.setTag("twitter");
				img3.setImageResource(socialNetwork[2]);
				img3.setTag("gtalk");				
				
				tr1.addView(img1);
				tr2.addView(it1);
				tr1.addView(img2);
				tr2.addView(it2);
				tr3.addView(img3);
				tr4.addView(it3);
				table.addView(tr1);
				table.addView(tr2);
				table.addView(tr3);
				table.addView(tr4);
			}
				else if(checkArray[0] == 5){
					it1.setText(eggSocialIcons[0]);
					it2.setText(eggSocialIcons[1]);
					it3.setText(eggSocialIcons[2]);
					img1.setImageResource(eggSocialNetwork[0]);
					img1.setTag("facebook");
					img2.setImageResource(eggSocialNetwork[1]);
					img2.setTag("twitter");
					img3.setImageResource(eggSocialNetwork[2]);	
					img3.setTag("gtalk");
					
					tr1.addView(img1);
					tr2.addView(it1);
					tr1.addView(img2);
					tr2.addView(it2);
					tr3.addView(img3);
					tr4.addView(it3);
					table.addView(tr1);
					table.addView(tr2);
					table.addView(tr3);
					table.addView(tr4);
				}
			}
			else if (currentPosition == 4) {
			Integer[] checkArray = SubMenu();
			if (checkArray[0] == 4) {
				it1.setText(FolderIcons[0]);
				it2.setText(FolderIcons[1]);
				it3.setText(FolderIcons[2]);
				img1.setImageResource(folder[0]);
				img1.setTag("muzik");
				img2.setImageResource(folder[1]);
				img2.setTag("resim");
				img3.setImageResource(folder[2]);
				img3.setTag("video");
				

				tr1.addView(img1);
				tr2.addView(it1);
				tr1.addView(img2);
				tr2.addView(it2);
				tr3.addView(img3);
				tr4.addView(it3);
				table.addView(tr1);
				table.addView(tr2);
				table.addView(tr3);
				table.addView(tr4);
			} 
			else if (checkArray[0] == 5) {
				it1.setText(eggFolderIcons[0]);
				it2.setText(eggFolderIcons[1]);
				it3.setText(eggFolderIcons[2]);
				img1.setImageResource(eggfolder[0]);
				img1.setTag("muzik");
				img2.setImageResource(eggfolder[1]);
				img2.setTag("resim");
				img3.setImageResource(eggfolder[2]);
				img3.setTag("video");

				tr1.addView(img1);
				tr2.addView(it1);
				tr1.addView(img2);
				tr2.addView(it2);
				tr3.addView(img3);
				tr4.addView(it3);
				table.addView(tr1);
				table.addView(tr2);
				table.addView(tr3);
				table.addView(tr4);
			}	         
			}
            img1.setOnFocusChangeListener(new OnFocusChangeListener(){
            	
				public void onFocusChange(View v, boolean hasFocus) {
					// when img1 was focused,its brightness will low
					if(img1.hasFocus())
			  			img1.setAlpha(900);
			  	    else 
			  	    	img1.setAlpha(1000);					
				}	
            });
            img2.setOnFocusChangeListener(new OnFocusChangeListener(){
            	
				public void onFocusChange(View v, boolean hasFocus) {
					// when img2 was focused,its brightness will low
					if(img2.hasFocus())
			  			img2.setAlpha(900);
			  	    else 
			  	    	img2.setAlpha(1000);					
				}	
            });
            img3.setOnFocusChangeListener(new OnFocusChangeListener(){
            	
				public void onFocusChange(View v, boolean hasFocus) {
					// when img3 was focused,its brightness will low
					if(img3.hasFocus())
			  			img3.setAlpha(900);
			  	    else 
			  	    	img3.setAlpha(1000);					
				}	
            });	           	
			img1.setOnClickListener(new OnClickListener(){
		        public void onClick(View arg){
		        	
		        	if(img1.getTag().toString()=="facebook"){
		        	
						startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com")).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK));
		        		
		        	}
		        	else if(img1.getTag().toString()=="muzik"){
		        		Toast toast = Toast.makeText(getApplicationContext(),"müzik", Toast.LENGTH_SHORT);
			             toast.show();		        				        		
		        	}
		        }
		    });
			img2.setOnClickListener(new OnClickListener(){
		        public void onClick(View arg){
		        	
		        	if(img2.getTag().toString()=="twitter"){
			        	
						//startActivity(new Intent("android.intent.action.VIEW", Uri.parse("file:///org.comu.homescreen-2.apk")).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK));
		        		launchApp("org.comu.homescreen-2.apk");
		        	}
		        	else if(img2.getTag().toString()=="resim"){
		        		Toast toast = Toast.makeText(getApplicationContext(),"resim", Toast.LENGTH_SHORT);
			            toast.show();		        			        		
		        	}	            
		        }
		    });   
			img3.setOnClickListener(new OnClickListener(){
		        public void onClick(View arg){
		        	if(img3.getTag().toString()=="gtalk"){
			        	
		        		Intent gtalk = new Intent(getApplicationContext(), XMPPClientActivity.class);
		        		startActivity(gtalk);
		        	}
		        	else if(img3.getTag().toString()=="video"){
		        		Toast toast = Toast.makeText(getApplicationContext(),"video", Toast.LENGTH_SHORT);
			            toast.show();		        				        		
		        	}	            
		        }
		    });  
	
}	
	/***
	 * 
	 * @param packageName
	 */
	
	
	protected void launchApp(String packageName) {
		
		        Intent mIntent = getPackageManager().getLaunchIntentForPackage(packageName);
		        if (mIntent != null) {
		            try {
		                startActivity(mIntent);		
		            } catch (ActivityNotFoundException err) {		
		                Toast t = Toast.makeText(getApplicationContext(), "app not found", Toast.LENGTH_SHORT);
		                	t.show();
		            }
		        }
		    }


	
	private Integer[] getEggGallery() {
		// Auto-generated method stub
		Integer[] dizi = new Integer[3];
		Cursor cursor = GetData("pastelisIconTable");
		try {
		  int i=0;
		  while (cursor.moveToNext()) {
			  String  yol_adi = cursor.getString(cursor.getColumnIndex("imagepath"));
			  Integer yol = Integer.parseInt(yol_adi);
	  		  dizi[i]=yol;
	  		  Log.v("DEBUG", "dizi: " + Integer.toString(dizi[i]));
	  		  i++;
	  	  }
			  
		  } catch (Exception e) {
			  // handle exception
			  }
		
		return dizi;
	}

	private Integer[] SubMenu(){
		 Integer[] checkArray = new Integer[1];
		  Cursor cursor = GetDataID("subIDTable");
		  try{
		  while(cursor.moveToFirst()){
			  int id = cursor.getInt(cursor.getColumnIndex("guncelID"));
			  checkArray[0] = id ;
			  Log.v("DEBUG", "checkArray:" + checkArray[0]);
			  break;		 
		  	}
		  } catch (Exception e) {
			// handle exception
		}
		  return checkArray;
	}
	
	private String[] SubThemeID = { "guncelID" };
	
	private Cursor GetDataID(String table) {
		// get data from database
		SQLiteDatabase db = imagepath.getReadableDatabase();
		Cursor cursor = db.query(table, SubThemeID, null, null,
				null, null, null);
		startManagingCursor(cursor);
		return cursor;
	}
	
	
	private Integer[] getGallery() {
		Integer[] dizi = new Integer[3];
		Cursor cursor = GetData("galleryIconTable");
		try {
		  int i=0;
		  while (cursor.moveToNext()) {
			  String  yol_adi = cursor.getString(cursor.getColumnIndex("imagepath"));
			  Integer yol = Integer.parseInt(yol_adi);
	  		  dizi[i]=yol;
	  		  Log.v("DEBUG", "dizi: " + Integer.toString(dizi[i]));
	  		  i++;
	  	  	}
		  } catch (Exception e) {
			  // handle exception
			  }
		return dizi;
	}

	private Integer[] getSocial() {
		// Auto-generated method stub
		Integer[] dizi = new Integer[3];
		Cursor cursor = GetData("socialIconTable");
		try {
		  int i=0;
		  while (cursor.moveToNext()) {
			  String  yol_adi = cursor.getString(cursor.getColumnIndex("imagepath"));
			  Integer yol = Integer.parseInt(yol_adi);
	  		  dizi[i]=yol;
	  		  Log.v("DEBUG", "dizi: " + Integer.toString(dizi[i]));
	  		  i++;
	  	  }
			  
		  } catch (Exception e) {
			  // handle exception
			  }
		
		return dizi;
	}
	
	private Integer[] getEggSocial() {
		// Auto-generated method stub
		Integer[] dizi = new Integer[3];
		Cursor cursor = GetData("eggsocialIconTable");
		try {
		  int i=0;
		  while (cursor.moveToNext()) {
			  String  yol_adi = cursor.getString(cursor.getColumnIndex("imagepath"));
			  Integer yol = Integer.parseInt(yol_adi);
	  		  dizi[i]=yol;
	  		  Log.v("DEBUG", "dizi: " + Integer.toString(dizi[i]));
	  		  i++;
	  	  }
			  
		  } catch (Exception e) {
			  // handle exception
			  }
		
		return dizi;
	}
	
	/**
	 * WallID 
	 */
	public int selected = 0;
	
	private  int whichWallpapers(){
		 int selected = 0;
		  Cursor cursor = GetDataID("WallIDTable");
		  try{
		  while(cursor.moveToFirst()){
			  int id = cursor.getInt(cursor.getColumnIndex("guncelID"));
			  selected = id ;
			  break;		 
		  	}
		  } catch (Exception e) {
			// handle exception
		}
		  return selected;
	}
	
	/**
	 * WhichWallPaper
	 */
	
	public Integer[] createList(){
		Integer[] dizi = new Integer[1];
		Integer selected = whichWallpapers();
		if(selected == 7){
			Cursor cursor = GetData("Wallpaper");
			try {
				int i=0;
				while(cursor.moveToNext()){
					String  yol_adi = cursor.getString(cursor.getColumnIndex("imagepath"));
					Integer yol = Integer.parseInt(yol_adi);
					dizi[i]=yol;
					Log.v("DEBUG", "dizi: " + Integer.toString(dizi[i]));
					i++;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if (selected == 8) {
			Cursor cursor = GetData("WallpaperBlue");
			try {
				int i=0;
				while(cursor.moveToNext()){
					String  yol_adi = cursor.getString(cursor.getColumnIndex("imagepath"));
					Integer yol = Integer.parseInt(yol_adi);
					dizi[i]=yol;
					Log.v("DEBUG", "dizi: " + Integer.toString(dizi[i]));
					i++;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return dizi;
	}

	private String[] SELECT = { "imagepath","etiket" };

	private Cursor GetData(String table) {
		// get data from database
		SQLiteDatabase db = imagepath.getReadableDatabase();
		Cursor cursor = db.query(table, SELECT, null, null,
				null, null, null);
		startManagingCursor(cursor);
		return cursor;
	}

	public static int updateId(){
		// after pressed the theme button on ThemeActivity class, update temacesitleritablosu's ids 
		 int id = ThemeActivity.mTemaId;
		 return id;	
	}
	
	private void setupCoverFlow(CoverFlow coverFlow) {
		// CoverFlow is assigned to the settings
		
		coverFlow.setAdapter(new ImageAdapter(this));
		ImageAdapter coverImageAdapter = new ImageAdapter(this);
		coverFlow.setOnItemClickListener(this);
		coverFlow.setAdapter(coverImageAdapter);       
		coverFlow.setSpacing(-10);
		coverFlow.setSelection(currentPosition, true);
		coverFlow.setAnimationDuration(1000);
		
	}

	public class ImageAdapter extends BaseAdapter {
		int mGalleryItemBackground;
		private Context mContext;
		
		Integer[] mImageIds = upgradeImageIds();
		
		public Integer[] theme(){
			Integer[] arrayID = new Integer[1];
			Cursor theme = GetDataID("IDTable");
			while(theme.moveToFirst()){
				int i=0;
				int themeID = theme.getInt(theme.getColumnIndex("guncelID"));
				arrayID[i] = themeID;
				Log.v("DEBUG", "hangi tema:" + themeID);
				break;
			}
			return arrayID;
		}
		
		private Integer[] upgradeImageIds() {
			// created an image array with imageIds from the database
			Integer[] dizi= new Integer[9];
//			int themeID = updateId();
			Integer[] themeID  = theme();
			Log.v("DEBUG", "theme durumu :" + themeID[0]);
			if(themeID[0] == 1){
				Cursor cursor = GetData("greyTheme");
				try {
				  int i=0;
				  while (cursor.moveToNext()) {
					  String  yol_adi = cursor.getString(cursor.getColumnIndex("imagepath"));
					  Integer yol = Integer.parseInt(yol_adi);
			  		  dizi[i]=yol;
			  		  Log.v("DEBUG", "dizi: " + Integer.toString(dizi[i]));
			  		  i++;
			  	  }
					  
				  } catch (Exception e) {
					  // handle exception
					  }
			  }
			else if(themeID[0] == 2){
				Cursor cursor = GetData("blueTheme");
				 try {
					  int i=0;
					  while (cursor.moveToNext()) {
						  String  yol_adi = cursor.getString(cursor.getColumnIndex("imagepath"));
						  Integer yol = Integer.parseInt(yol_adi);
				  		  dizi[i]=yol;
				  		  Log.v("DEBUG", "dizi: " + Integer.toString(dizi[i]));
				  		  i++;
				  	  }
						  
					  } catch (Exception e) {
						  // handle exception
						  }	
			}
			  return dizi;	  
		}
			

		private String[] SELECT = { "imagepath","etiket" };
		
		private Cursor GetData(String table) {
			// get data from database
			SQLiteDatabase db = imagepath.getReadableDatabase();
			Cursor cursor = db.query(table, SELECT, null, null,
					null, null, null);
			startManagingCursor(cursor);
			return cursor;
		}

		private String[] ThemeID = { "guncelID" };
		
		private Cursor GetDataID(String table) {
			// get data from database
			SQLiteDatabase db = imagepath.getReadableDatabase();
			Cursor cursor = db.query(table, ThemeID, null, null,
					null, null, null);
			startManagingCursor(cursor);
			return cursor;
		}
		

		private ImageView[] mImages;

		public ImageAdapter(Context c) {
			mContext = c;
			mImages = new ImageView[mImageIds.length];
		}

		public boolean createReflectedImages() {

			final int reflectionGap = 4;

			int index = 0;
			for (int imageId : mImageIds) {
				Bitmap originalImage = BitmapFactory.decodeResource(
						getResources(), imageId);
				int width = originalImage.getWidth();
				int height = originalImage.getHeight();

				// This will not scale but will flip on the Y axis
				Matrix matrix = new Matrix();
				matrix.preScale(1, -1);

				// Create a Bitmap with the flip matrix applied to it.
				// We only want the bottom half of the image
				Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0,
						height / 2, width, height / 2, matrix, false);

				// Create a new bitmap with same width but taller to fit
				// reflection
				Bitmap bitmapWithReflection = Bitmap.createBitmap(width,
						(height + height / 2), Config.ARGB_8888);

				// Create a new Canvas with the bitmap that's big enough for
				// the image plus gap plus reflection
				Canvas canvas = new Canvas(bitmapWithReflection);
				// Draw in the original image
				canvas.drawBitmap(originalImage, 0, 0, null);
				// Draw in the gap
				Paint deafaultPaint = new Paint();
				canvas.drawRect(0, height, width, height + reflectionGap,
						deafaultPaint);
				// Draw in the reflection
				canvas.drawBitmap(reflectionImage, 0, height + reflectionGap,
						null);

				// Create a shader that is a linear gradient that covers the
				// reflection
				Paint paint = new Paint();
				LinearGradient shader = new LinearGradient(0,
						originalImage.getHeight(), 0,
						bitmapWithReflection.getHeight() + reflectionGap,
						0x70ffffff, 0x00ffffff, TileMode.CLAMP);
				// Set the paint to use this shader (linear gradient)
				paint.setShader(shader);
				// Set the Transfer mode to be porter duff and destination in
				paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
				// Draw a rectangle using the paint with our linear gradient
				canvas.drawRect(0, height, width,
						bitmapWithReflection.getHeight() + reflectionGap, paint);

				ImageView imageView = new ImageView(mContext);
				imageView.setImageBitmap(bitmapWithReflection);
				imageView.setLayoutParams(new CoverFlow.LayoutParams(240, 360));
				imageView.setScaleType(ScaleType.MATRIX);
				mImages[index++] = imageView;

			}
			return true;
		}
		public int getCount() {
			return mImageIds.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public final long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {

			// Use this code if you want to load from resources
			ImageView i = new ImageView(mContext);
			i.setImageResource(mImageIds[position]);
			i.setLayoutParams(new CoverFlow.LayoutParams(200, 300));
			i.setScaleType(ImageView.ScaleType.FIT_XY);

			// Make sure we set anti-aliasing otherwise we get jaggies
			BitmapDrawable drawable = (BitmapDrawable) i.getDrawable();
			drawable.setAntiAlias(true);
			return i;

			// return mImages[position];
		}

		/**
		 * Returns the size (0.0f to 1.0f) of the views depending on the
		 * 'offset' to the center.
		 */
		public float getScale(boolean focused, int offset) {
			/* Formula: 1 / (2 ^ offset) */
			return Math
					.max(0, 1.0f / (float) Math.pow(1 / 2, Math.abs(offset)));
		}
	
	}
	public void onItemClick(AdapterView<?> Gallery, View arg1, int position, long arg3) {
		// Icons in the menu is clicked
		String[] dizi={"Tarayıcı", "Sosyal Aglar","Youtube","Gmail","Galeri","Oyunlar", "Wikipedia", "İndirilenler","Ayarlar"};
		Toast.makeText(getApplicationContext(), ""+dizi[position], Toast.LENGTH_LONG).show();

	    position++;


			switch (position){

				case 1:startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.google.com")));
				   currentPosition=position-1;
				break;

				case 2:Intent viewIntent2 = new Intent(getApplicationContext(), SubMenuActivity.class);				
				startActivity(viewIntent2);
				currentPosition=position-1;
				break;

				case 3:Intent viewIntent3 = new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com"));				
				startActivity(viewIntent3);
				currentPosition=position-1;
				break;

				case 4:startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://mail.google.com/mail/")));
				   currentPosition=position-1;
				break;

				case 5:Intent viewIntent5 = new Intent(getApplicationContext(), SubMenuActivity.class);				
				startActivity(viewIntent5);
				currentPosition=position-1;
				break;

				case 6:Intent viewIntent6 = new Intent(getApplicationContext(), GameSubMenu.class);				
				startActivity(viewIntent6);
				currentPosition=position-1;
				break;

				case 7:startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://tr.wikipedia.org/wiki/Ana_Sayfa")));
				   currentPosition=position-1;
				break;

				case 8:Intent viewIntent8 = new Intent(new Intent(android.provider.Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS));				
				startActivity(viewIntent8);
				currentPosition=position-1;
				break;

				case 9:Intent viewIntent9 = new Intent(getApplicationContext(), ThemeActivity.class);				
				startActivity(viewIntent9);
				   currentPosition=position-4;
				break;


			}

	}

	@Override
	public void onBackPressed() {

		Intent MainScreen= new Intent(getApplicationContext(),CoverFlowClickableActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(MainScreen);

	}
	
}
