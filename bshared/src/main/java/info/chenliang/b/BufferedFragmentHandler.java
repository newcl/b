package info.chenliang.b;

import io.aeron.logbuffer.FragmentHandler;
import io.aeron.logbuffer.Header;
import org.agrona.DirectBuffer;

public class BufferedFragmentHandler implements FragmentHandler {
    @Override
    public void onFragment(DirectBuffer buffer, int offset, int length, Header header) {

    }
}
