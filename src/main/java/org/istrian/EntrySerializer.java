package org.istrian;

import org.jetbrains.annotations.NotNull;
import org.mapdb.DataInput2;
import org.mapdb.DataOutput2;
import org.mapdb.Serializer;

import java.io.IOException;
import java.io.Serializable;

public class EntrySerializer implements Serializer<Entry>, Serializable {

    @Override
    public void serialize(@NotNull DataOutput2 out, @NotNull Entry value) throws IOException {
        out.writeInt(value.getId());
        out.writeInt(value.getType().getMultiplier());
        out.writeDouble(value.getAmount());
        out.writeUTF(value.getDescription());
    }

    @Override
    public Entry deserialize(@NotNull DataInput2 input, int available) throws IOException {
        return new Entry(input.readInt(), input.readInt() == -1 ? EntryType.OUTFLOW : EntryType.INCOME,
                input.readDouble(), input.readUTF());
    }
}
