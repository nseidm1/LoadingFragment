LoadingFragment
===============

<img src="http://upload.wikimedia.org/wikipedia/commons/2/2d/Pbar.gif"/>

Implementing the LoadingFragment is just like a regular fragment. Management of the 
progress bar is done completely behind the scenes as your View is programatically injected 
into the structured view hierarchy.

LoadingFragment has three abstract methods:

<pre><code>public abstract View onCreateMainView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
public abstract int setInAnimation();
public abstract int setOutAnimation();</pre></code>
    
onCreateMainView is identicaly to onCreateView of a standard fragment. setIn and setOutAnimation 
return an int of the anim resource to use respectively for the in and out transition.

There are two public methods:

<pre><code>showContent()
showLoading()</pre></code>

The starting screen is the progress bar, after your content is done loading simply 
call showContent(). If you need to reload your view's data, call showLoading() first if 
desired.

<pre><code>Copyright 2012 Noah Seidman

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</code></pre>
