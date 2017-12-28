# FingerthCommonAdapter
一个简单的Listview、GridView适配器；一个简单的ViewPager适配器；一个简单的RecyclerView适配器，RecyclerView可以有头部和尾部。

> 打造万能的适配器，超级简单使用，省时省力。

> Step 1. Add the JitPack repository to your build file
> 
> Add it in your root build.gradle at the end of repositories:

	
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

> Step 2. Add the dependency

	
```
dependencies {
		compile 'com.github.fingerth:commonadapter:1.2.0'
	}
```

[![](https://jitpack.io/v/fingerth/commonadapter.svg)](https://jitpack.io/#fingerth/commonadapter)


### CommonAdapter<T> 一个简单的ListView和GrideView的适配器

```
        ListView lv;
        
        ArrayList<String> list = new ArrayList<>();
        //list.add("ViewPager Demo");
        
        lv.setAdapter(new CommonAdapter<String>(this, list, android.R.layout.simple_list_item_1) {
            @Override
            public void convert(ViewHolder helper,int position, String item) {
                helper.setText(android.R.id.text1, item);
            }
        });
```

### CommonPagerAdapter<T> 一款简单的ViewPager适配器


```

        ViewPager vp;

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            arrayList.add("pager : " + i);
        }

        vp.setAdapter(new CommonPagerAdapter<String>(this, arrayList, R.layout.pager_item_view) {
            @Override
            public void convert(PagerHolder holder, String item) {
                holder.setText(R.id.tv, item);
            }
        });

```
    
    > 要支持无限滑怎办，不要担心，用这个UnlimitedSlidePagerAdapter<T>
    
    
``` 
        ViewPager vp;

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            arrayList.add("unlimited pager : " + i);
        }

        UnlimitedSlidePagerAdapter<String> unlimitedSlidePagerAdapter = new UnlimitedSlidePagerAdapter<String>(this, arrayList, R.layout.pager_item_view) {
            @Override
            public void convert(PagerHolder holder, String item) {
                holder.setText(R.id.tv, item);
            }
        };
        vp.setAdapter(unlimitedSlidePagerAdapter);
        vp.setCurrentItem(unlimitedSlidePagerAdapter.getMidPosition(), false);
```
### CommonRecyclerAdapter<T> 一款简单的RecyclerView适配器

> 正常使用

```

        RecyclerView rv;

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            arrayList.add("item:" + i);
        }

        GridLayoutManager manager = new GridLayoutManager(this, 2);
        rv.setLayoutManager(manager);
        rv.setAdapter(new CommonRecyclerAdapter<String>(this, arrayList) {

            @Override
            public int setLayoutId(int viewType) {
                return android.R.layout.simple_list_item_1;
            }

            @Override
            public void onBind(Holder holder, int RealPosition, String data) {
                holder.setText(android.R.id.text1, data);
            }
        });
```
> 有头部，有尾部


```

        RecyclerView rv;

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            arrayList.add("item:" + i);
        }

        CommonRecyclerAdapter<String> adapter = new CommonRecyclerAdapter<String>(this, arrayList) {

            @Override
            public int setLayoutId(int viewType) {
                return android.R.layout.simple_list_item_1;
            }

            @Override
            public void onBind(Holder holder, int RealPosition, String data) {
                holder.setText(android.R.id.text1, data);
            }
        };
        View mHeaderView = View.inflate(this, R.layout.view_header, null);
        adapter.setHeaderView(mHeaderView);
        View mFootView = View.inflate(this, R.layout.view_foot, null);
        adapter.setFootView(mFootView);

        GridLayoutManager manager = new GridLayoutManager(this, 2);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
```

> 不同Item的使用


```

        RecyclerView rv;

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            arrayList.add("item:" + i);
        }

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(manager);
        rv.setAdapter(new CommonRecyclerAdapter<String>(this, arrayList) {

            @Override
            public int itemViewType(int position) {
                if (position % 3 == 1) {
                    return 0x88;
                }
                return super.itemViewType(position);
            }

            @Override
            public int setLayoutId(int viewType) {
                switch (viewType) {
                    case 0x88:
                        return R.layout.view_foot;
                    default:
                        return android.R.layout.simple_list_item_1;
                }
            }

            @Override
            public void onBind(Holder holder, int RealPosition, String data) {
                switch (holder.getItemViewType()) {
                    case 0x88:
                        holder.setText(R.id.tv, data);
                        break;
                    default:
                        holder.setText(android.R.id.text1, data);
                        break;
                }

            }
        });
```











