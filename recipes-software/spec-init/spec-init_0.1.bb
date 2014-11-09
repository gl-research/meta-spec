SUMMARY = "Provides spec_init.bin golden bitstream for default boot time FPGA configuration"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

PR = "r0"
PV = "0.1"


SRC_URI = "http://www.ohwr.org/attachments/download/1756/spec-init.bin-2012-12-14"
SRC_URI[md5sum] = "acc3778d05999ddb23771bac74ec270f"

S = "${WORKDIR}/"

FILES_${PN} += "/lib/firmware/fmc"

do_compile() {
    :
}

do_install() {
             install -d ${D}/lib/firmware/fmc
             install -m 0755 ${S}/spec-init.bin-2012-12-14 ${D}/lib/firmware/fmc/spec-init.bin
}



# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
