// IMediaService.aidl
package com.example.binderserver;
import com.example.binderserver.MediaInfo;

// Declare any non-default types here with import statements
interface IMediaService{
void startplay(in MediaInfo info);
void stop();
void search(String name);
}