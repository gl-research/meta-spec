SUMMARY = "Bitstream for the SPEC user demo in the Getting Started guide"


LICENSE = "LGPL-3.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-3.0;md5=bfccfe952269fff2b407dd11f2f3083b"

inherit module

PR = "r0"
PV = "0.1"


SRC_URI = "http://www.ohwr.org/attachments/download/3654/spec_demo_user.bin"
SRC_URI[md5sum] = "4f5c2f469bce43c2e9ff280aa94e661e"

S = "${WORKDIR}/"

FILES_${PN} += "/lib/firmware/fmc"

do_compile() {
    :
}

do_install() {
             install -d ${D}/lib/firmware/fmc
             install -m 0755 ${S}/spec_demo_user.bin ${D}/lib/firmware/fmc/spec_demo_user.bin
}



# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
