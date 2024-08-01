package com.rokid.os.master.screenstream;

import android.view.Surface;

interface ISurfaceProvider {
  void setSurface(in Surface surface);

  void getSurface(out List<Surface> surface);
}
